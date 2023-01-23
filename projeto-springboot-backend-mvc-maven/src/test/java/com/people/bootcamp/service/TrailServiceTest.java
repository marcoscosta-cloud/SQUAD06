package com.people.bootcamp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.people.bootcamp.controller.exceptions.NotFoundException;
import com.people.bootcamp.controller.exceptions.UserNotFoundException;
import com.people.bootcamp.controller.model.GetCountersResponse;
import com.people.bootcamp.repository.UserRepository;
import com.people.bootcamp.repository.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.people.bootcamp.controller.exceptions.TrailNotFoundException;
import com.people.bootcamp.repository.TrailRepository;
import com.people.bootcamp.repository.model.ContentModel;
import com.people.bootcamp.repository.model.TrailModel;
import com.people.bootcamp.service.domain.Trail;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TrailServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);

    private final TrailRepository trailRepository = mock(TrailRepository.class);

    private TrailService trailService = new TrailService(trailRepository, userRepository);


    @BeforeEach
    public void init() {
        //inicializar os mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void executeFindByIdWithValidIdWithAExistingTrailWillSuccessfully() {
        final Long id = Long.valueOf(1);
        String title = "Java";

        when(trailRepository.findById(id)).thenReturn(Optional.ofNullable(TrailModel.builder().title(title).build()));

        Optional<Trail> trail = null;
        try {
            trail = trailService.findById(id);
        } catch (NotFoundException e) {
            fail("Trail not found");
        }

        assertTrue(trail.isPresent());
        assertEquals(title, trail.get().getTitle());
    }

    @Test
    void executeFindByIdWithValidIdWithANonExistingTrail() {
        final Long id = Long.valueOf(654);

        when(trailRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> trailService.findById(id),
                "Expected should throw an Exception");
    }

    @Test
    void executeFindByIdWithNullArgumentsWillFail() {
        final Long id = null;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> trailService.findById(id),
                "Expected should throw an Exception");

        assertTrue(thrown.getMessage().contains(TrailService.ID_CAN_NOT_BE_NULL));
    }
    
    
    @Test
    void findAllSuccessfully() {
    	List<ContentModel> contents = new ArrayList<>();
    	final TrailModel trail01 = new TrailModel(1L, "Trilha1", "pipipipópópó", "icone", "codigo01", contents);
    	ContentModel content1 = ContentModel.builder().id(1L).description("Java").typeContent("OO").urlContent("site").urlImage("imagem").build();
    	contents.add(content1);
    	List<TrailModel> listTrail = List.of(trail01);
        when(trailRepository.findAll()).thenReturn(listTrail);
        Optional<List<Trail>> all = trailService.findAll();
        assertNotNull(all);
        assertTrue(all.isPresent());
        List<Trail> listaRetornada = all.get();
        assertTrue(listaRetornada.size() == 1);
        for(Trail trail : listaRetornada) {
        	assertEquals(trail.getDescription(), trail01.getDescription());
        }
    }

    void executeGetUserCountersSuccessfully() {
        final Long trailId = 1l;
        final Long userId = 1l;
        final Long content1Id = 1l;
        final Long content2Id = 2l;

        final ContentModel content1 = ContentModel.builder().id(content1Id).build();
        final ContentModel content2 = ContentModel.builder().id(content2Id).build();

        final TrailModel trailModel = TrailModel.builder().id(trailId).contents(List.of(content1, content2)).build();
        final UserModel userModel = UserModel.builder().id(userId).contents(List.of(content1)).build();

        when(trailRepository.findById(trailId)).thenReturn(Optional.of(trailModel));
        when(userRepository.findById(userId)).thenReturn(Optional.of(userModel));

        try {
            GetCountersResponse response = trailService.getUserCounters(trailId, userId);
            assertNotNull(response);
            assertTrue(trailId.equals(response.getTrailId()));
            assertTrue(userId.equals(response.getUserId()));
            assertTrue(response.getTotalContents() == 2l);
            assertTrue(response.getConcludedContents() == 1l);
            assertTrue(response.getUserTrailPercent() == 50.0);

        } catch (TrailNotFoundException | UserNotFoundException e) {
            fail(e);
        }
    }
}