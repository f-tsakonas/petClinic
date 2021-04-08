package org.adesso;

import org.adesso.pages.AddPet;
import org.adesso.pages.FindOwner;
import org.adesso.pages.NewOwner;
import org.adesso.pages.OwnerInformation;

public class Aufgabe6uc {
    private FindOwner findOwner = new FindOwner();
    private NewOwner newOwner = new NewOwner();
    private AddPet addPet = new AddPet();
    private OwnerInformation ownerInformation = new OwnerInformation();

    public void searchOwner(String name){
        findOwner.goToFindOwners();
        findOwner.search(name);
    }

    public void addNewOwner(String firstName, String lastName, String address, String city, String telephone){
        findOwner.goToFindOwners();
        findOwner.clickAddNewOwner();
        newOwner.fillAddNewOwnerForm(firstName, lastName, address, city, telephone);
        newOwner.clickAddOwner();
        ownerInformation.verifyOwnerInformationPageLoaded();
        ownerInformation.verifyOwnerInformationPageBelongs(lastName);
    }

    public void addNewPet(String name, String birthDate, String type){
        ownerInformation.clickAddNewPet();
        addPet.fillAddNewPetForm(name, birthDate, type);
        addPet.clickAddPet();
        ownerInformation.verifyOwnerInformationPageLoaded();
    }

}
