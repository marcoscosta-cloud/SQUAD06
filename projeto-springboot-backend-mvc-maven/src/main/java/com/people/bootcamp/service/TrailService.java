package com.people.bootcamp.service;
import java.util.List;
import java.util.Optional;

import com.people.bootcamp.controller.exceptions.NotFoundException;
import com.people.bootcamp.controller.exceptions.UserNotFoundException;
import com.people.bootcamp.controller.model.GetCountersResponse;
import com.people.bootcamp.repository.UserRepository;
import com.people.bootcamp.repository.model.ContentModel;
import com.people.bootcamp.repository.model.UserModel;
import com.people.bootcamp.service.domain.UserModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.people.bootcamp.controller.exceptions.TrailNotFoundException;
import com.people.bootcamp.repository.TrailRepository;
import com.people.bootcamp.repository.model.TrailModel;
import com.people.bootcamp.service.domain.Trail;
import com.people.bootcamp.service.domain.TrailModelMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class TrailService {

    public static final String ID_CAN_NOT_BE_NULL = "ID não pode estar vazio";

    private final TrailRepository trailRepository;

    private final UserRepository userRepository;


    public Optional<Trail> findById(Long id)  {
        if (null == id) {
            log.error(ID_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(ID_CAN_NOT_BE_NULL);
        }
        return Optional.ofNullable(TrailModelMapper.INSTANCE.modelToEntity(trailRepository.findById(id).orElseThrow(NotFoundException::new)));
    }

    public Optional<List<Trail>> findAll() {
    	List<TrailModel> trailModelList = trailRepository.findAll();
    	List<Trail> trailList = TrailModelMapper.INSTANCE.modelToEntity(trailModelList);
    	return Optional.ofNullable(trailList);
    }

    public GetCountersResponse getUserCounters(Long id, Long userId)
            throws TrailNotFoundException, UserNotFoundException {
        Optional<TrailModel> trail = trailRepository.findById(id);
        if (trail.isEmpty()) {
            throw new TrailNotFoundException(id);
        }

        Optional<UserModel> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException(userId);
        }

        long totalContents = trail.get().getContents().size();
        long totalUsersContents = 0;
        double userContentsPercent = 0.0;

        List<ContentModel> userContents = user.get().getContents();
        List<ContentModel> trailContents = trail.get().getContents();
        for (ContentModel content : trailContents) {
            if (userContents.contains(content)) {
                totalUsersContents++;
            }
        }

        if (totalContents != 0) {
            double x = totalUsersContents;
            userContentsPercent = (x / totalContents) * 100.0;
        }

        return new GetCountersResponse(userId, id, totalUsersContents, totalContents, userContentsPercent);
    }
}