package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class TopKMostUniqueEmails {


    /**
     * Given a list of email objects, find top K persons who received most number of emails - done
     * <p>
     * Count only unique emails from above then find top K elements - done.
     * Use hashset to keep track of unique from-to-email-and-message
     */

    static class Email {
        String fromPerson;
        String toPerson;
        String message;

        Email(String fromPerson, String toPerson, String message) {
            this.fromPerson = fromPerson;
            this.toPerson = toPerson;
            this.message = message;
        }
    }

    static class UniqueEmail{
        String fromPerson;
        String toPerson;

        public UniqueEmail(String fromPerson, String toPerson) {
            this.fromPerson = fromPerson;
            this.toPerson = toPerson;
        }

        @Override
        public String toString() {
            return "UniqueEmail{" +
                    "fromPerson='" + fromPerson + '\'' +
                    ", toPerson='" + toPerson + '\'' +
                    '}';
        }
    }


    private static List<UniqueEmail> topKMostUniqueEmails(List<Email> emails, int k) {
        List<UniqueEmail> result = new ArrayList<>();
        Map<UniqueEmail, Integer> uniqueEmailCount = new HashMap<>();

        Set<UniqueEmail> seen = new HashSet<>();
        for(Email e : emails){
//            if(!seen.contains(new UniqueEmail(e.fromPerson, e.toPerson))){
//                seen.add(new UniqueEmail(e.fromPerson, e.toPerson));
//            }
            UniqueEmail uniqueEmail = new UniqueEmail(e.fromPerson, e.toPerson);
            if(uniqueEmailCount.containsKey(uniqueEmail)) {
                uniqueEmailCount.put(uniqueEmail,
                        uniqueEmailCount.getOrDefault(new UniqueEmail(e.fromPerson, e.toPerson), 0) + 1);
            }else{
                //
            }
        }

        System.out.println(">>>>>>" + uniqueEmailCount.keySet());

        PriorityQueue<UniqueEmail> heap = new PriorityQueue<>((a, b) -> Integer.compare(uniqueEmailCount.get(a), uniqueEmailCount.get(b)));

        for(UniqueEmail email : uniqueEmailCount.keySet()){
            heap.add(email);
            if(heap.size() > k){
                heap.poll();
            }
        }


//        while(!heap.isEmpty()){
//            result.add(heap.poll());
//        }


        UniqueEmail[] output = new UniqueEmail[k];
        for(int i = k - 1; i >=0; i--){
            System.out.println(">>>>" + Arrays.toString(output));
            output[i] = heap.poll();
            System.out.println(">>>>" + Arrays.toString(output));
        }

        result = Arrays.asList(output);
        System.out.println(">>>>" + result);


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

        System.out.println(topKMostUniqueEmails(emails, 4));
    }
}
