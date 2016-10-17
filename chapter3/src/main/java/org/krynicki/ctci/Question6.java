package org.krynicki.ctci;

import java.util.Calendar;
import java.util.Date;
import java.util.Queue;

/**
 * Created by K on 2016-10-17.
 */
public class Question6 {
    class AnimalShelter {
        private Queue<Dog> dogs;
        private Queue<Cat> cats;
        private Queue<Animal> all;

        public void enqueue(Cat cat) {
            cat.setAdmissionDate(Calendar.getInstance().getTime());
            cats.add(cat);
        }

        public void enqueue(Dog dog) {
            dog.setAdmissionDate(Calendar.getInstance().getTime());
            dogs.add(dog);
        }

        public Animal dequeueAny() {
            if (dogs.isEmpty()) {
                return dequeueCat();
            }

            if (cats.isEmpty()) {
                return dequeueDog();
            }

            if (dogs.peek().compareTo(cats.peek()) < 0) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }

        public Cat dequeueCat() {
            return cats.remove();
        }

        public Dog dequeueDog() {
            return dogs.remove();
        }
    }

    private class Dog extends Animal {
    }

    private class Cat extends Animal {
    }

    private class Animal implements Comparable<Animal> {
        Date admissionDate;

        public Date getAdmissionDate() {
            return admissionDate;
        }

        public void setAdmissionDate(Date admissionDate) {
            this.admissionDate = admissionDate;
        }

        @Override
        public int compareTo(Animal that) {
            return this.getAdmissionDate().compareTo(that.getAdmissionDate());
        }
    }
}
