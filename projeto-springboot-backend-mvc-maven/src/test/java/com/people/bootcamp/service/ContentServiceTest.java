package com.people.bootcamp.service;

import com.people.bootcamp.repository.ContentRepository;
import com.people.bootcamp.repository.UserRepository;
import com.people.bootcamp.repository.model.ContentModel;
import com.people.bootcamp.repository.model.UserModel;
import com.people.bootcamp.service.domain.Content;
import com.people.bootcamp.service.domain.ContentModelMapper;
import com.people.bootcamp.service.domain.Trail;
import com.people.bootcamp.service.domain.TrailModelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@DisplayName("Deve retornar Trail")
//@RunWith(MockitoJUnitRunner.class)

public class ContentServiceTest {

    @Mock
    private ContentRepository contentRepository;

    @InjectMocks
    private ContentService contentService;

    @BeforeEach
    public void init() {
        //inicializar os mocks
        MockitoAnnotations.initMocks(this);
    }

    private final UserRepository userRepository = mock(UserRepository.class);

    private UserService userService = new UserService(userRepository);

    @Test
    void executeFindContentsByTrailsId() {
        final Long trailId = 1l;

        String title = "Java OO";

        List<ContentModel> contentModelList = new ArrayList<ContentModel>();
        ContentModel content = new ContentModel();
        content.setId(1l);
        content.setTitle(title);
        content.setDescription("Descrição return");
        content.setTypeContent("Conteudo return");
        content.setUrlContent("https://www.teste.com.br");
        content.setUrlImage("https://www.teste.com.br/image");
        contentModelList.add(content);

        List<Content> contentList = ContentModelMapper.INSTANCE.modelToEntity(contentModelList);

        Optional<List<ContentModel>> contentOpt = Optional.of(contentModelList);
        when(contentRepository.findContentsByTrailsId(trailId)).thenReturn(contentOpt);
        Optional<List<Content>> optResult = contentService.findContentsByTrailsId(trailId);

        assertNotNull(optResult);
        assertTrue(optResult.isPresent());
        List<Content> result = optResult.get();
        // Verificando se a lista resultante eh igual a lista que foi gerada
        assertTrue(contentList.size() == result.size() &&
                contentList.containsAll(result) &&
                result.containsAll(contentList));
    }
    @Test
    void executeFindContentsByTrailsIdWithNullArguments() {
        final Long trailId = null;

        when(contentRepository.findContentsByTrailsId(trailId)).thenReturn(Optional.empty());
        Optional<List<Content>> optResult = contentService.findContentsByTrailsId(trailId);

        assertTrue(optResult.isEmpty());
    }

    @SuppressWarnings("unused")
    @Nested
    class MarkContent {
        final Long idUser = 1L;
        final Long idContent = 1L;

        final List<UserModel> users = new ArrayList();
        final List<ContentModel> contents = new ArrayList();

        final UserModel user = new UserModel();
        final ContentModel content = new ContentModel();

        @Test
        void markContentToList() {

            when(contentRepository.findById(idContent))
                    .thenReturn(Optional.of(ContentModel.builder().id(idContent).users(users).build()));
            Optional<ContentModel> contentModel = contentRepository.findById(idContent);

            when(userRepository.findById(idUser))
                    .thenReturn(Optional.of(UserModel.builder().id(idUser).contents(contents).build()));
            Optional<UserModel> userModel = userRepository.findById(idUser);

            contentService.markContent(idUser, idContent);

            System.out.println(userModel.get().getContents().get(0));
            assertTrue(userModel.get().getContents().size() > 0);
            assertTrue(userModel.get().getContents().contains(contentModel.get()));
        }

        @Test
        void unMarkContentFromList() {
            when(contentRepository.findById(idContent))
                    .thenReturn(Optional.of(ContentModel.builder().id(idContent).users(users).build()));
            Optional<ContentModel> contentModel = contentRepository.findById(idContent);

            when(userRepository.findById(idUser))
                    .thenReturn(Optional.of(UserModel.builder().id(idUser).contents(contents).build()));
            Optional<UserModel> userModel = userRepository.findById(idUser);

            userModel.get().getContents().add(contentModel.get());

            contentService.unMarkContent(idUser, idContent);
            assertTrue(userModel.get().getContents().size() == 0);
            assertFalse(userModel.get().getContents().contains(contentModel.get()));
        }
    }
}
