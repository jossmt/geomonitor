/**
 * Created by jossmillertodd on 04/03/2017.
 */


import java.util.List;

/**
 * News api integration service.
 */
public interface NewsApiIntegrationService {

    /**
     * Funnels bbc news data.
     *
     * @return abstract response integration model.
     */
    AbstractResponseIntegrationModel getNewsFunnel(final ResourceUrls resourceUrl,
                                                         final NewsCategories newsCategoy);
}
