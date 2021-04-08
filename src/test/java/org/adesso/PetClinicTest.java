package org.adesso;


  @Test
public void addEduarosPet(){
    goToFindOwners();
    searchOwner("Rodriquez");
    goToAddNewPet();
    addNewPet("Lucky2", "06.07.2009", "cat");
    petsAndVisitsHeader.shouldBe(visible);
    $(byText("Lucky2")).shouldBe(visible);
}

   @Test
public void addHarry(){
    PetClinicUC.goToFindOwners();
    PetClinicUC.clickAddOwner();
    PetClinicUC.addNewOwner("Harry", "Potter", "Ligusterweg 12", "London", "123456");
    $(editOwnerBtn).shouldBe(visible);
    $(ownerInformationHeader).shouldBe(visible);
}

   @Test
public void sucheEduardo(){
	PetClinicUC.goToFindOwners();
	PetClinicUC.searchOwner("Rodriquez");
    $(byText("Owner Information")).shouldBe(visible);
    $(byText("Eduardo Rodriquez")).shouldBe(visible);
}

  @Test
public void sucheDavis(){
	PetClinicUC.goToFindOwners();
	PetClinicUC.searchOwner("Davis");
    $(byText("Betty Davis")).shouldBe(visible);
    $(byText("Harold Davis")).shouldBe(visible);
}

}
