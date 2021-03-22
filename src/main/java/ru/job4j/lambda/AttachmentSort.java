package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 50),
                new Attachment("image 3", 20));
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment attach1 = (Attachment) o1;
                Attachment attach2 = (Attachment) o2;
                return attach1.getSize() - attach2.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> atachComp = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(atachComp);
    }
}
