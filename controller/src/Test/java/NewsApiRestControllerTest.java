import com.jmt.geomonitor.controller.core.NewsApiRestController;
import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;
import com.jmt.geomonitor.service.core.NewsApiService;
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
 * config for {@link NewsApiRestController}
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsApiRestControllerTest {

    /** Resource url. */
    private ResourceUrls resourceUrl = ResourceUrls.GUARDIAN;

    /** news category. */
    private NewsCategories newsCategory = NewsCategories.STUDENT;

    /** {@link NewsApiService} */
    @Mock
    private NewsApiService newsApiService;

    /** {@link NewsApiRestController} */
    private NewsApiRestController newsApiRestController;

    /**
     * news api rest controller test setup.
     */
    @Before
    public void setUp() {
        newsApiRestController = new NewsApiRestController(newsApiService);

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
        newsStoryModel.setUrlToImage(Arrays.asList(new URL("http://www.TestUrlImg.com")));
        newsStoryModel.setUrl(new URL("http://www.TestUrl.com"));
        newsStoryModel.setCopyRight("TestCopyRight");
        newsStoryModel.setPublishedAt("TestPublishedAt");

        //Mock
        Mockito.when(newsApiService.getNewsStories(resourceUrl, newsCategory)).thenReturn(Arrays.asList
                (newsStoryModel));

        //config
        newsApiRestController.getNewsStoriesByCategory("GUARDIAN", "STUDENT");

        //Verify
        Mockito.verify(newsApiService).getNewsStories(resourceUrl, newsCategory);

        //Assertion
    }

}
