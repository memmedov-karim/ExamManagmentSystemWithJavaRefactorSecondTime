package com.example.ExamManagmentSystemRefactorization.service.ticket;

import com.example.ExamManagmentSystemRefactorization.constant.ConstantVariable;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketRequestDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.newticket.NewTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforregion.RegionTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.dto.ticket.ticketforuser.UserTicketResponseDto;
import com.example.ExamManagmentSystemRefactorization.entity.Center;
import com.example.ExamManagmentSystemRefactorization.entity.Exam;
import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.Ticket;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.mapper.ticket.TicketMapper;
import com.example.ExamManagmentSystemRefactorization.repository.TicketRepository;
import com.example.ExamManagmentSystemRefactorization.service.center.CenterService;
import com.example.ExamManagmentSystemRefactorization.service.exam.ExamService;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import com.example.ExamManagmentSystemRefactorization.service.user.UserService;
import com.example.ExamManagmentSystemRefactorization.service.utis.UtisService;
import com.example.ExamManagmentSystemRefactorization.util.region.RegionResourceChecker;
import com.example.ExamManagmentSystemRefactorization.util.user.UserResourceChecker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final RegionService regionService;
    private final CenterService centerService;
    private final ExamService examService;
    private final UtisService utisService;
    private final UserService userService;
    private final RegionResourceChecker regionResourceChecker;
    private final UserResourceChecker userResourceChecker;
    private final TicketMapper ticketMapper;
    @Override
    public NewTicketResponseDto addNewTicket(Long regionid, NewTicketRequestDto newTicketRequestDto){
        Region exsitingRegion = regionService.findRegionById(regionid);
        regionResourceChecker.ThrowExceptionIfRegionDoesnotExist(exsitingRegion);
        Long centerid = newTicketRequestDto.getCenter_id();
        Center existingCenter = centerService.findCenterById(centerid);
        Long examid = newTicketRequestDto.getExam_id();
        Exam existingExam = examService.findExamById(examid);
        Ticket savedTicket = ticketRepository.save(creatNewTicketInstance(exsitingRegion,existingExam,existingCenter,
                newTicketRequestDto));
        return NewTicketResponseDto
                .builder()
                .examname(existingExam.getName())
                .examdateandtime(existingExam.getDateandtime())
                .centername(existingCenter.getName())
                .centercode(existingCenter.getCode())
                .centercity(existingCenter.getCity())
                .clas(savedTicket.getClas())
                .fenn(savedTicket.getFenn())
                .sector(savedTicket.getSector())
                .name(savedTicket.getName())
                .surname(savedTicket.getSurname())
                .father(savedTicket.getFather())
                .room(savedTicket.getRoom())
                .place(savedTicket.getPlace())
                .phone(savedTicket.getPhone())
                .build();
    }





    private Ticket creatNewTicketInstance(Region exsitingRegion,Exam existingExam,Center existingCenter,NewTicketRequestDto newTicketRequestDto){
        Ticket newTicketInstance = new Ticket();
        newTicketInstance.setRegion(exsitingRegion);
        newTicketInstance.setExam(existingExam);
        newTicketInstance.setCenter(existingCenter);
        //Burada centerin ve region heqiqtend usere aid olduqunu validate etmeliyem
        newTicketInstance.setClas(newTicketRequestDto.getClas());
        newTicketInstance.setFenn(newTicketRequestDto.getFenn());
        newTicketInstance.setSector(newTicketRequestDto.getSector());
        newTicketInstance.setName(newTicketRequestDto.getName());
        newTicketInstance.setSurname(newTicketRequestDto.getSurname());
        newTicketInstance.setFather(newTicketRequestDto.getFather());
        newTicketInstance.setRoom(newTicketRequestDto.getRoom());
        newTicketInstance.setPlace(newTicketRequestDto.getPlace());
        newTicketInstance.setPhone(newTicketRequestDto.getPhone());
        newTicketInstance.setUtis(utisService.generateUniqueUtis(exsitingRegion, ConstantVariable.Numbers.UTISLENGTH));
        return newTicketInstance;
    }



    @Override
    public List<RegionTicketResponseDto> getListOfRegionTickets(Long regionid){
        Region existingRegion = regionService.findRegionById(regionid);
        regionResourceChecker.ThrowExceptionIfRegionDoesnotExist(existingRegion);
        return ticketMapper.mapToListRegionTicketResponseDto(existingRegion.getTickets());
    }
    @Override
    public List<UserTicketResponseDto> getListOfUserTickets(Long userid){
        User existingUser = userService.findUserById(userid);
        userResourceChecker.ifUserDoesnotExistThrowException(existingUser);
        return ticketMapper.mapToListUserTicketResponseDto(ticketRepository.findByRegion_User_Id(userid));
    }

}
