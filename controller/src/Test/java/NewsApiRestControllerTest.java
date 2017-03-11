import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link NewsApiRestController}
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsApiRestControllerTest {

    /** Resource url. */
    private ResourceUrls resourceUrl = ResourceUrls.THE_GUARDIAN;

    /** News category. */
    private NewsCategories newsCategory = NewsCategories.STUDENT;

    /** {@link NewsApiService} */
    @Mock
    private NewsApiService newsApiService;

    /** {@link NewsApiRestController} */
    private NewsApiRestController newsApiRestController;

    /**
     * News api rest controller test setup.
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

        //Test
        final Response response = newsApiRestController.getNewsStoriesByCategory("THE_GUARDIAN", "STUDENT");

        //Verify
        Mockito.verify(newsApiService).getNewsStories(resourceUrl, newsCategory);

        //Assertion
        final List<NewsStoryModel> newsStoryModels = (List<NewsStoryModel>) response.getEntity();
        Assert.assertEquals(newsStoryModels.get(0), newsStoryModel);
    }

}
