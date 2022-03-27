package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class BusinessSimilarity {


    /**
     * Business Similarity
     * -------------------
     * If someone leaves a positive review on yelp, chances are the person enjoyed the business and  would be looking
     * for similar businesses. If many users left positive reviews for the same two businesses, we can say those
     * two businesses are similar
     * <p>
     * The definition of how similar two businesses are to one other is defined as:
     * <p>
     * AnB/AuB
     * <p>
     * where:
     * AnB = number of unique users who reviewed both businesses
     * AuB = number of unique users who reviewed either one
     * <p>
     * Given a list of positive reviews, and a business of interest, find and return the business id most similar
     * to the business of interest
     */

    /*
        Sample Input

        {
        "businessOfInterestId": 10,
        "positiveReviews": [
            PositiveReview(
                "userId": 1,
                "businessId": 10
            ),
            PositiveReview(
                "userId": 2,
                "businessId": 10
            ),
            PositiveReview(
                "userId": 1,
                "businessId": 11
            ),
            PositiveReview(
                "userId": 2,
                "businessId": 11
            ),
            PositiveReview(
                "userId": 1,
                "businessId": 12
            ),
            PositiveReview(
                "userId": 2,
                "businessId": 12
            ),
            PositiveReview(
                "userId": 3,
                "businessId": 12
            )
           ]
        }

        Sample Output
        11

        Business Similarity Score against business 10:
        11: 2 / (2 + 2 - 2) = 1.0
        12: 2 / (2 + 3 - 2) = 0.667
    */


    static class PositiveReview {
        Integer userId;
        Integer businessId;

        PositiveReview(Integer userId, Integer businessId) {
            this.userId = userId;
            this.businessId = businessId;
        }

        Integer getUserId() {
            return this.userId;
        }

        Integer getBusinessId() {
            return this.businessId;
        }
    }


    private static Integer findMostSimilarBusiness(Integer businessOfInterestId, List<PositiveReview> positiveReviews) {

        //Initial base case
        int mostSimilarBusiness = -1;
        if (positiveReviews == null || positiveReviews.size() == 0) {
            return mostSimilarBusiness;
        }


        //Create map to hold similar biz from perspective of individual users making the positive reviews
        Map<Integer, Set<Integer>> similarBiztoUserMap = new HashMap<>();

        //Next we iterate through the positive review list to populate the set with each user that made a positive
        // review to the corresponding business
        for (PositiveReview p : positiveReviews) {
            similarBiztoUserMap.putIfAbsent(p.getBusinessId(), new HashSet<>());
            similarBiztoUserMap.get(p.getBusinessId()).add(p.getUserId());
        }

        //Now, we need to do a comparision across all business ids to get the most similar business

        //First we need something to keep track of highest rate as we traverse
        double highestRate = 0.0;

        //Next, we run through each Keyset so we can calculate AnB/AuB for each Keyset. The highest value is our most similar business
        for (Integer bizId : similarBiztoUserMap.keySet()) {
            //Remember, we don't care about the business of Interest, we only need to find the most similar to it. Hence...
            if (!bizId.equals(businessOfInterestId)) {
                System.out.println(">>>>>>>------------");
                System.out.println(">>>>>>>Comparing " + businessOfInterestId + " against " + bizId);
                Set<Integer> businessUsersInterested = new HashSet<>(similarBiztoUserMap.get(businessOfInterestId));
                System.out.println(">>>>>>>After Add all" + businessUsersInterested);

                //For intersection: N(A ∩ B)
                double intersection = 0.0;
                businessUsersInterested.retainAll(similarBiztoUserMap.get(bizId));
                System.out.println(">>>>>>>After Retain all" + businessUsersInterested);
                intersection = businessUsersInterested.size();
                System.out.println(">>>>>>> Intersection>>> " + intersection);


                //For union:  N(A U B) = N(A) + N(B) - N(A ∩ B)
                double union = similarBiztoUserMap.get(bizId).size() + similarBiztoUserMap.get(businessOfInterestId).size() - intersection;
                System.out.println(">>>>>>>Union>> " + union);


                //For rate
                double rate = intersection/union;
                System.out.println(">>>>>>>Rate>> " + rate);

                System.out.println();

                //if rate is higher, update the tracker and the most similar business variable
                if(rate > highestRate){
                    highestRate = rate;
                    mostSimilarBusiness = bizId;
                }

            }

        }


        return mostSimilarBusiness;
    }


    public static void main(String[] args) {

        List<PositiveReview> positiveReviews = new ArrayList<>();
        positiveReviews.add(new PositiveReview(1, 10));
        positiveReviews.add(new PositiveReview(2, 10));
        positiveReviews.add(new PositiveReview(1, 11));
        positiveReviews.add(new PositiveReview(2, 11));
        positiveReviews.add(new PositiveReview(1, 12));
        positiveReviews.add(new PositiveReview(2, 12));
        positiveReviews.add(new PositiveReview(3, 12));

        int businessOfInterest = 10;

        System.out.println(">>>>>>>>>>>" + findMostSimilarBusiness(businessOfInterest, positiveReviews));

    }
}
