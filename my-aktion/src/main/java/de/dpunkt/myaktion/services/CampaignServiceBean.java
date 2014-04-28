package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Organizer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CampaignServiceBean implements CampaignService {
    @Inject
    EntityManager entityManager;

    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Campaign> getAllCampaigns() {
        TypedQuery<Campaign> query = entityManager.createNamedQuery(Campaign.findByOrganizer, Campaign.class);
        query.setParameter("organizer", getLoggedinOrganizer());
        List<Campaign> campaigns = query.getResultList();
        campaigns.forEach(campaign -> campaign.setAmountDonatedSoFar(getAmountDonatedSoFar(campaign)));
        return campaigns;
    }

    @Override
    public void addCampaign(Campaign campaign) {
        Organizer organizer = getLoggedinOrganizer();
        campaign.setOrganizer(organizer);
        entityManager.persist(campaign);
    }

    @Override
    public void deleteCampaign(Campaign campaign) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaign.getId());
        entityManager.remove(managedCampaign);
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        entityManager.merge(campaign);
    }

    private Double getAmountDonatedSoFar(Campaign campaign) {
        TypedQuery<Double> query = entityManager.createNamedQuery(Campaign.getAmountDonatedSoFar, Double.class);
        query.setParameter("campaign", campaign);
        Double result = query.getSingleResult();
        if (result == null)
            result = 0d;
        return result;
    }

    private Organizer getLoggedinOrganizer() {
        String organizerEmail = sessionContext.getCallerPrincipal().getName();
        Organizer organizer = entityManager.createNamedQuery(Organizer.findByEmail, Organizer.class)
                .setParameter("email", organizerEmail).getSingleResult();
        return organizer;
    }


}
