package bg.softuni.happytravel.schedulers;

import bg.softuni.happytravel.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class OffersCountScheduler {

    Logger logger = LoggerFactory.getLogger(OffersCountScheduler.class);
    private final OfferService offerService;

    public OffersCountScheduler(OfferService offerService) {
        this.offerService = offerService;
    }

    @Scheduled(cron = "30 4 * * *")
    public void offersCountSchedule(){
        Long offersCount = offerService.countOffers();
        logger.info("The offers count is: " + offersCount);
    }
}
