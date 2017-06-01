package com.jmt.geomonitor.controller.core;

import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
import com.jmt.geomonitor.service.core.CountryDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Country data request controller layer
 */
@Controller
@RequestMapping(value = "/map")
public class CountryDataController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CountryDataController.class);

    /** {@link CountryDataService} */
    private final CountryDataService countryDataService;

    /**
     * Constructor.
     *
     * @param countryDataService
     *         Country data service.
     */
    @Autowired
    public CountryDataController(final CountryDataService countryDataService) {
        this.countryDataService = countryDataService;
    }

    /**
     * Returns country data from online using name
     *
     * @param name
     *         Name.
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ModelAndView getCountryData(@PathVariable final String name) {

        LOG.debug("Returning country data for {}", name);

        final ModelAndView modelAndView = new ModelAndView();

        final CountryDataModel countryDataModel = countryDataService.fetchCountryInformationBy(name);

        modelAndView.addObject("countryData", countryDataModel);
        modelAndView.setViewName("MonitorDashboard");

        LOG.debug("Exiting controller - returning country data for {}", name);

        return modelAndView;
    }

}
