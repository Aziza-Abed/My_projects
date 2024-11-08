package com.example.allyrgywiseapp;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AllergyMockupData {
    private List<AllergyMockupData> allergytypes;
    private List<AllergyMockupData> allergytypesExamples;
    private String TypeName;
    private  String TypeDescription;
    private String AllergyName;
    private int imageID;
    private String Allergyinfo;

    public AllergyMockupData(String typeName,int imageID, String typeDescription) {
        TypeName = typeName;
        TypeDescription = typeDescription;
        this.imageID = imageID;
    }
    public AllergyMockupData(String typeName, String allergyName, int imageID , String allergyinfo) {
        TypeName = typeName;
        AllergyName = allergyName;
        this.imageID = imageID;
        Allergyinfo =  allergyinfo;
    }

    public AllergyMockupData() {
        allergytypes = new ArrayList<>();
        allergytypesExamples = new ArrayList<>();

        //list of allergy types
        allergytypes.add(new AllergyMockupData("Food Allergies",R.drawable.food, "Food allergies occur when the immune system mistakenly identifies certain proteins in food as harmful. Common allergens include: "));
        allergytypes.add(new AllergyMockupData("Environmental Allergies",R.drawable.environmental, "Environmental allergies, also known as airborne allergies, are reactions to allergens in the environment. Common triggers include:"));
        allergytypes.add(new AllergyMockupData("Drug Allergies (Medications)", R.drawable.drug,"Drug allergies occur when the immune system reacts to a medication. Common examples include:"));
        allergytypes.add(new AllergyMockupData("Insect Allergies", R.drawable.insects,"Insect allergies are triggered by bites or stings from certain insects, most notably:"));
        allergytypes.add(new AllergyMockupData("Skin Allergies", R.drawable.skin,"Skin allergies can arise from contact with allergens, leading to conditions like:"));

        // list of examples for each allergy type
        allergytypesExamples.add(new AllergyMockupData("Food Allergies", "Peanuts", R.drawable.peanut, "Often triggers severe reactions, including anaphylaxis \n requires avoidance even in trace amounts."));
        allergytypesExamples.add(new AllergyMockupData("Food Allergies", "Shellfish", R.drawable.shellfish, " Common allergen among adults; includes both crustaceans (like shrimp) and mollusks (like clams)."));
        allergytypesExamples.add(new AllergyMockupData("Food Allergies", "Dairy", R.drawable.dairy, "Caused by sensitivity to proteins in milk, such as casein and whey; especially common in children."));
        allergytypesExamples.add(new AllergyMockupData("Food Allergies", "Gluten", R.drawable.gluten, "Contains wheat, barley, or rye. Avoid if allergic or intolerant. May cause digestive discomfort, fatigue, or skin reactions."));
        allergytypesExamples.add(new AllergyMockupData("Food Allergies", "Fish", R.drawable.fish, "Includes fish like salmon, tuna, or cod. Avoid if allergic. Can cause swelling, hives, or severe reactions like anaphylaxis."));
        allergytypesExamples.add(new AllergyMockupData("Food Allergies", "Soy", R.drawable.soy, "Often found in processed foods, making it hard to avoid; commonly outgrown in childhood."));

        allergytypesExamples.add(new AllergyMockupData("Environmental Allergies","Pollen",R.drawable.pollen, "Released by trees, grasses, and weeds, especially in spring and summer; symptoms include sneezing and itchy eyes."));
        allergytypesExamples.add(new AllergyMockupData("Environmental Allergies","Mold",R.drawable.mold, "Thrives in damp environments; mold spores can be inhaled, triggering respiratory symptoms."));
        allergytypesExamples.add(new AllergyMockupData("Environmental Allergies","Pet Dander",R.drawable.petdander, "Made up of tiny skin flakes and saliva proteins from pets; can trigger symptoms even if pets aren’t present."));
        allergytypesExamples.add(new AllergyMockupData("Environmental Allergies","Grass",R.drawable.grass, " Causes hay fever symptoms like itchy eyes and sneezing; common in late spring and summer."));
        allergytypesExamples.add(new AllergyMockupData("Environmental Allergies","Dust Mites",R.drawable.dustmites, " Microscopic organisms in household dust; common trigger for asthma and respiratory allergies."));
        allergytypesExamples.add(new AllergyMockupData("Environmental Allergies","Cockroach Droppings",R.drawable.cockroach, " Contains proteins that can trigger asthma and other allergic reactions."));

        allergytypesExamples.add(new AllergyMockupData("Drug Allergies (Medications)","Penicillin",R.drawable.penicillin, "Most common drug allergy; can cause hives, swelling, and severe anaphylaxis."));
        allergytypesExamples.add(new AllergyMockupData("Drug Allergies (Medications)","Aspirin",R.drawable.aspiren, "Can trigger asthma symptoms and other reactions; those with asthma are more susceptible."));
        allergytypesExamples.add(new AllergyMockupData("Drug Allergies (Medications)","Ibuprofen",R.drawable.ibuprofen, "NSAID that can cause hives or anaphylaxis in sensitive individuals."));
        allergytypesExamples.add(new AllergyMockupData("Drug Allergies (Medications)","Sulfa Drugs",R.drawable.sulfadrugs, "Includes antibiotics like sulfamethoxazole; can cause rashes and, in rare cases, serious reactions like Stevens-Johnson syndrome."));
        allergytypesExamples.add(new AllergyMockupData("Drug Allergies (Medications)","Anesthetics",R.drawable.anesthetics, "Used in surgeries; can cause reactions like hives, low blood pressure, and respiratory issues."));
        allergytypesExamples.add(new AllergyMockupData("Drug Allergies (Medications)","Anticonvulsants",R.drawable.anticonvulsants, "Can cause reactions in people sensitive to specific seizure medications, including serious skin rashes."));

        allergytypesExamples.add(new AllergyMockupData("Insect Allergies","Bee Stings",R.drawable.bee, "Can cause intense local swelling or, in severe cases, anaphylaxis; bee allergy sufferers often carry epinephrine."));
        allergytypesExamples.add(new AllergyMockupData("Insect Allergies","Wasp Stings",R.drawable.wasp, "Similar to bee stings, but wasps can sting multiple times; reactions may be severe."));
        allergytypesExamples.add(new AllergyMockupData("Insect Allergies","Fire Ant Stings",R.drawable.fireant, "Known for their painful, burning sting; can cause intense localized swelling or systemic reactions."));
        allergytypesExamples.add(new AllergyMockupData("Insect Allergies","Hornet Stings",R.drawable.hornet, "Related to wasps, hornets can also sting multiple times; reactions can be life-threatening."));
        allergytypesExamples.add(new AllergyMockupData("Insect Allergies","Yellow Jacket Stings",R.drawable.yellowjacket, "Aggressive stingers, especially in late summer; causes severe reactions in sensitive individuals."));
        allergytypesExamples.add(new AllergyMockupData("Insect Allergies","Mosquito Bites",R.drawable.mosquito, "Often causes mild itching and swelling; some people may experience larger welts or intense itching."));

        allergytypesExamples.add(new AllergyMockupData("Skin Allergies","Latex",R.drawable.latex, "Reaction to latex products like gloves; can cause hives, itching, and even anaphylaxis in severe cases."));
        allergytypesExamples.add(new AllergyMockupData("Skin Allergies","Poison Ivy",R.drawable.ivy, "Contains urushiol, an oil that triggers an itchy, blistering rash on contact."));
        allergytypesExamples.add(new AllergyMockupData("Skin Allergies","Nickel",R.drawable.nickel, "Found in jewelry and metal items; causes contact dermatitis, characterized by itchy and red skin."));
        allergytypesExamples.add(new AllergyMockupData("Skin Allergies","Fragrances",R.drawable.fragrances, "Used in personal care products; can cause skin irritation or respiratory symptoms in sensitive individuals."));
        allergytypesExamples.add(new AllergyMockupData("Skin Allergies","Hair Dyes",R.drawable.hairdyes, "Commonly contains PPD, a chemical that can cause severe allergic skin reactions."));
        allergytypesExamples.add(new AllergyMockupData("Skin Allergies","Cleaning Chemicals",R.drawable.cleaning, "Harsh chemicals in cleaning products can cause skin irritation, rashes, or even respiratory issues in some people."));

    }

    // Returns an array of allergy type names.
    public String[] getAllergyTypes() {
        return new String[]{"Food Allergies", "Environmental Allergies", "Drug Allergies (Medications)", "Insect Allergies", "Skin Allergies"};
    }
    // Return the description of allergy type based on the type name.
    public String getDescriptionByType(String allergyType) {
        for (AllergyMockupData type : allergytypes) {
            if (type.TypeName.equals(allergyType)) {
                return type.TypeDescription;
            }
        }
        return "";
    }

    // Returns a list of specific allergies within a given allergy type.
    public List<AllergyMockupData> getAllergyByType(String allergyType) {
        List<AllergyMockupData> result = new ArrayList<>();
        for (AllergyMockupData example : allergytypesExamples) {
            if (example.TypeName.equals(allergyType)) {
                result.add(example);
            }
        }
        return result;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    // Returns the image ID of a specific allergy type based on the type name.
    public int getImageIDByType(String allergyType) {
        for (AllergyMockupData type : allergytypes) {
            if (type.TypeName.equals(allergyType)) {
                return type.getImageID();
            }
        }
        return 0;
    }

    // Gets info for allergy example based on the allergy name.
    public String getInfoByName(String allergy_name) {
        for (AllergyMockupData name : allergytypesExamples) {
            if (name.AllergyName.equals(allergy_name)) {
                return name.Allergyinfo;
            }
        }
        return "";
    }

    public String getAllergyName() {
        return AllergyName;
    }

    public void setAllergyName(String allergyName) {
        AllergyName = allergyName;
    }

    @NonNull
    @Override
    public String toString() {
        return AllergyName != null ? AllergyName : TypeName;
    }

}