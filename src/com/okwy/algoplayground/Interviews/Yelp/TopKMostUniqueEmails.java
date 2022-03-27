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

    static class UniqueEmail {
        String fromPerson;
        String toPerson;

        UniqueEmail(String fromPerson, String toPerson) {
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


    //Tuple solution incompleteeeeee
    private static List<UniqueEmail> topKMostUniqueEmailsTuple(List<Email> emails, int k) {
        List<UniqueEmail> result = new ArrayList<>();
        Map<UniqueEmail, Integer> uniqueEmailCount = new HashMap<>();

        Set<UniqueEmail> seen = new HashSet<>();
        for (Email e : emails) {
            if (!seen.stream().anyMatch(a -> a.fromPerson.equals(e.fromPerson) && a.toPerson.equals(e.toPerson))) {
                seen.add(new UniqueEmail(e.fromPerson, e.toPerson));
            } else {
                //uniqueEmailCount.put(seen.)
            }

        }

        System.out.println(">>>>>>" + uniqueEmailCount.keySet());

        PriorityQueue<UniqueEmail> heap = new PriorityQueue<>((a, b) -> Integer.compare(uniqueEmailCount.get(a), uniqueEmailCount.get(b)));

        for (UniqueEmail email : uniqueEmailCount.keySet()) {
            heap.add(email);
            if (heap.size() > k) {
                heap.poll();
            }
        }


//        while(!heap.isEmpty()){
//            result.add(heap.poll());
//        }


        UniqueEmail[] output = new UniqueEmail[k];
        for (int i = k - 1; i >= 0; i--) {
            System.out.println(">>>>" + Arrays.toString(output));
            output[i] = heap.poll();
            System.out.println(">>>>" + Arrays.toString(output));
        }

        result = Arrays.asList(output);
        System.out.println(">>>>" + result);


        return result;

    }


    /////////////////////////////////////////////////////////////////


    private static List<String> topKMostUniqueEmailsString(List<Email> emails, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> uniqueEmailCount = new HashMap<>();


        for (Email e : emails) {
            uniqueEmailCount.put(e.toPerson + "-" + e.fromPerson, uniqueEmailCount.getOrDefault(e.toPerson + "-" + e.fromPerson, 0) + 1);
        }

        PriorityQueue<String> uniqueHeap = new PriorityQueue<>((a, b) -> Integer.compare(uniqueEmailCount.get(a), uniqueEmailCount.get(b)));

        for (String uniquePair : uniqueEmailCount.keySet()) {
            uniqueHeap.add(uniquePair);
            if (uniqueHeap.size() > k) {
                uniqueHeap.poll();
            }
        }

        String[] output = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            output[i] = uniqueHeap.poll();
        }

        result = Arrays.asList(output);


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

//        System.out.println(topKMostUniqueEmailsTuple(emails, 4));
        System.out.println(topKMostUniqueEmailsString(emails, 4));
    }


}
