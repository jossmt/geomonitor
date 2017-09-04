package news;

import com.jmt.geomonitor.controller.core.NewsController;
import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;
import com.jmt.geomonitor.service.core.NewsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * config for {@link NewsController}
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsControllerTest {

    /** Resource url. */
    private ResourceUrls resourceUrl = ResourceUrls.GUARDIAN;

    /** news category. */
    private NewsCategories newsCategory = NewsCategories.STUDENT;

    /** {@link NewsService} */
    @Mock
    private NewsService newsService;

    /** {@link NewsController} */
    private NewsController newsController;

    /**
     * news api rest controller test setup.
     */
    @Before
    public void setUp() {
        newsController = new NewsController(newsService);

    }

    /**
     * Checks newsapi method.
     */
    @Test
    public void checkNewsApiRestControllerResponse() throws MalformedURLException {

        //Setup
        final NewsStoryModel newsStoryModel = new NewsStoryModel();
        newsStoryModel.setTitle("TestTitle");
        newsStoryModel.setAuthor("TestAuthor");
        newsStoryModel.setDescription("TestDescription");
        newsStoryModel.setUrlToImage("http://www.TestUrlImg.com");
        newsStoryModel.setUrl(new URL("http://www.TestUrl.com"));
        newsStoryModel.setCopyRight("TestCopyRight");
        newsStoryModel.setPublishedAt("TestPublishedAt");

        //Mock
        Mockito.when(newsService.getNewsStories(resourceUrl, newsCategory)).thenReturn(Arrays.asList
                (newsStoryModel));

        //config
        newsController.getNewsStoriesByCategory("GUARDIAN", "STUDENT");

        //Verify
        Mockito.verify(newsService).getNewsStories(resourceUrl, newsCategory);
    }

}
