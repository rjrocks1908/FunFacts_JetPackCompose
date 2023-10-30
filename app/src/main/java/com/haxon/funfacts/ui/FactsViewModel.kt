package com.haxon.funfacts.ui

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomFacts(selectedAnimal: String): String {
        return if (selectedAnimal == "dog") {
            getDogFacts().random()
        } else {
            getCatFacts().random()
        }
    }

    fun getDogFacts(): List<String> {
        val dogFacts = listOf(
            "Dogs have an extraordinary sense of smell.",
            "The Basenji dog is known as the 'barkless dog' because it doesn't bark like other dogs.",
            "Dogs have been domesticated for over 20,000 years.",
            "The Greyhound is one of the fastest dog breeds, capable of reaching speeds up to 45 miles per hour.",
            "A dog's nose print is unique, similar to a human's fingerprint.",
            "Dogs have sweat glands only in their paw pads.",
            "The Border Collie is considered one of the most intelligent dog breeds.",
            "There are over 340 different dog breeds worldwide.",
            "A dog's hearing is four times more acute than a human's.",
            "The world's smallest dog breed is the Chihuahua."
        )
        return dogFacts
    }

    fun getCatFacts(): List<String> {
        val catFacts = listOf(
            "Cats have a strong territorial instinct.",
            "The Maine Coon is one of the largest domestic cat breeds.",
            "Cats have a unique grooming behavior to keep clean and bond with their owners.",
            "A group of cats is called a clowder.",
            "Cats can jump up to six times their body length in one leap.",
            "The average cat sleeps for 12-16 hours a day.",
            "Cats communicate with each other through meowing, purring, and body language.",
            "The Siamese cat is known for its striking blue almond-shaped eyes.",
            "Cats have retractable claws to help with climbing and hunting.",
            "Ancient Egyptians worshiped and revered cats as sacred animals."
        )
        return catFacts
    }


}