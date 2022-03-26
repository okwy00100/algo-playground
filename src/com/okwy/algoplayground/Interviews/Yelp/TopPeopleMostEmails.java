package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class TopPeopleMostEmails {

    /**
     * Given a list of email objects, find top K persons who received most number of emails - done
     *
     * Count only unique emails from above then find top K elements - done.
     * Use hashset to keep track of unique from-to-email-and-message
     * */

    static class Email{
        String fromPerson;
        String toPerson;
        String message;

        Email(String fromPerson, String toPerson, String message) {
            this.fromPerson = fromPerson;
            this.toPerson = toPerson;
            this.message = message;
        }
    }


    private static List<String> topKMostEmails(List<Email> emails, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> emailCount = new HashMap<>();

        for(Email e : emails){
            emailCount.put(e.toPerson, emailCount.getOrDefault(e.toPerson, 0) + 1);
        }

        //initialize a heap with 'the less frequent element first'
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> emailCount.get(a) - emailCount.get(b));


        //keep the k most frequent people in the heap
        for(String person : emailCount.keySet()){
            heap.add(person);
            if(heap.size() >k){
                heap.poll();
            }
        }

        while(!heap.isEmpty()){
            result.add(heap.poll());
        }


        return result;
    }

    public static void main(String[] args) {

        List<Email> emails = new ArrayList<>();

        emails.add(new Email("John", "Peter", "bread"));
        emails.add(new Email("John", "Seun", "bread"));
        emails.add(new Email("Seun", "Okwy", "bread"));
        emails.add(new Email("Seun", "John", "bread"));
        emails.add(new Email("Seun", "Jack", "bread"));
        emails.add(new Email("Okwy", "Peter", "bread"));
        emails.add(new Email("Okwy", "Peter", "bread"));
        emails.add(new Email("Okwy", "Peter", "bread"));
        emails.add(new Email("Okwy", "Seun", "bread"));
        emails.add(new Email("John", "Seun", "bread"));

        System.out.println(topKMostEmails(emails, 4));

    }
}
