package com.solution.goncharova;

import com.solution.goncharova.entity.*;
import com.solution.goncharova.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;



/**
 * Class {@code Main} in package {@code com.solution.goncharova}
 * Homework where we find solutions JDBC
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class Main {

    /**
     * Create log4j2 logger
     * */
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        deleteEntities();
        createEntities();
        findEntitiesById();
        findAllEntities();
    }

    private static void deleteEntities() {
        CountriesServices countriesServices = new  CountriesServices();
        Countries country = new Countries();
        country.setCountryId(1);
        country.setCountry("Ukraine");
        countriesServices.deleteCountry(country);

        CitiesServices citiesServices = new  CitiesServices();
        Cities city = new Cities();
        city.setCityId(1);
        city.setCity("Kharkiv");
        citiesServices.deleteCity(city);

        AuthorServices authorServices = new AuthorServices();
        Author author = new Author();
        author.setAuthorId(1);
        author.setAuthorName("Джеймс");
        author.setAuthorSurname("Кервуд");
        author.setAuthorMiddleName("Оливер");
        author.setAuthorBirthday("12.01.1909");
        authorServices.deleteAuthor(author);

        BookServices bookServices = new BookServices();
        Books book = new Books();
        book.setBookId(1);
        book.setBookTitle("Kazans sun");
        book.setBookPrice(BigDecimal.valueOf(666666666));
        book.setCountOfPages(6789);
        book.setBookIsbn("34-89-90");
        book.setBookHide(false);
        book.setBookGenre("Роман");
        book.setYearOfPublishing("5.08.1956");
        book.setPublishing_house_id(1);
        book.setAuthor_id(1);
        bookServices.deleteBooks(book);

        PublishingHouseServices publishingHouseServices = new PublishingHouseServices();
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setPublishingHouseId(1);
        publishingHouse.setPublishingHouseName("Small book");
        publishingHouse.setPublishingHousePhoneNumber(066134567);
        publishingHouse.setPublishingHouseStreet("Naukova");
        publishingHouse.setPublishingHouseNumber("6g");
        publishingHouse.setPublishingHouseFlatNumber("9");
        publishingHouse.setPublishingHousePostcode(3838);
        publishingHouse.setCountry_id(1);
        publishingHouse.setCity_id(1);
        publishingHouseServices.deletePublishingHouse(publishingHouse);

        PurchaseServices purchaseServices = new PurchaseServices();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(1);
        purchase.setDate_purchaseAdding("1.09.2010");
        purchase.setDate_purchaseDeleting("5.09.2010");
        purchase.setDate_purchasePayment("5.09.2010");
        purchase.setBookCount(1);
        purchase.setBookPrice(BigDecimal.valueOf(666666666));
        purchase.setBookDeleted(false);
        purchase.setBookPaid(true);
        purchase.setBook_id(1);
        purchase.setUser_id(1);
        purchaseServices.deletePurchase(purchase);

        RegisteredUserRoleServices registeredUserRoleServices = new RegisteredUserRoleServices();
        RegisteredUserRole registeredUserRole = new RegisteredUserRole();
        registeredUserRole.setRegisterUserRoleId(1);
        registeredUserRole.setUser_id(1);
        registeredUserRole.setUser_type_id(1);
        registeredUserRoleServices.deleteRegisteredUserRole(registeredUserRole);


        StorageServices storageServices = new StorageServices();
        Storage storage = new Storage();
        storage.setStorageId(1);
        storage.setBookId(1);
        storage.setBookCount(3900000);
        storage.setStorageStreet("Academic");
        storage.setStorageHouseNumber("9k");
        storage.setStorageFlatNumber("67j");
        storage.setCountry_id(1);
        storage.setCity_id(1);
        storageServices.deleteStorage(storage);

        UserServices userServices = new UserServices();
        User user = new User();
        user.setUserId(1);
        user.setUser_name("Anna");
        user.setUser_surname("Goncharova");
        user.setUser_middle_name("Sergeevna");
        user.setUser_sex("f");
        user.setUser_email("anna@anna");
        user.setUser_username("Anna1233");
        user.setUser_password("nnnnn");
        user.setUser_birthday("12.08.2001");
        user.setUser_country_id(1);
        user.setUser_city_id(1);
        user.setUser_street("terora");
        user.setUser_house_number("45t");
        user.setUser_flat_number("12");
        user.setUser_type_id(1);
        userServices.deleteUser(user);

        UserTypeServices userTypeServices = new UserTypeServices();
        UserType userType = new UserType();
        userType.setUserTypeId(1);
        userType.setUserType("admin");
        userTypeServices.deleteUserType(userType);


        AccessRightsListServices accessRightsListServices = new AccessRightsListServices();
        AccessRightsList accessRightsList = new AccessRightsList();
        accessRightsList.setUserRightId(1);
        accessRightsList.setUser_type_id(1);
        accessRightsList.setRights("delete books");
        accessRightsListServices.deleteAccessRightsList(accessRightsList);

    }

    private static void createEntities() {

        CountriesServices countriesServices = new  CountriesServices();
        Countries country = new Countries();
        country.setCountryId(1);
        country.setCountry("Ukraine");
        countriesServices.saveCountry(country);

        CitiesServices citiesServices = new  CitiesServices();
        Cities city = new Cities();
        city.setCityId(1);
        city.setCity("Kharkiv");
        citiesServices.saveCity(city);

        AuthorServices authorServices = new AuthorServices();
        Author author = new Author();
        author.setAuthorId(1);
        author.setAuthorName("Джеймс");
        author.setAuthorSurname("Кервуд");
        author.setAuthorMiddleName("Оливер");
        author.setAuthorBirthday("12.01.1909");
        authorServices.saveAuthor(author);

        BookServices bookServices = new BookServices();
        Books book = new Books();
        book.setBookId(1);
        book.setBookTitle("Kazans sun");
        book.setBookPrice(BigDecimal.valueOf(666666666));
        book.setCountOfPages(6789);
        book.setBookIsbn("34-89-90");
        book.setBookHide(false);
        book.setBookGenre("Роман");
        book.setYearOfPublishing("5.08.1956");
        book.setPublishing_house_id(1);
        book.setAuthor_id(1);
        bookServices.saveBooks(book);

        PublishingHouseServices publishingHouseServices = new PublishingHouseServices();
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setPublishingHouseId(1);
        publishingHouse.setPublishingHouseName("Small book");
        publishingHouse.setPublishingHousePhoneNumber(066134567);
        publishingHouse.setPublishingHouseStreet("Naukova");
        publishingHouse.setPublishingHouseNumber("6g");
        publishingHouse.setPublishingHouseFlatNumber("9");
        publishingHouse.setPublishingHousePostcode(3838);
        publishingHouse.setCountry_id(1);
        publishingHouse.setCity_id(1);
        publishingHouseServices.savePublishingHouse(publishingHouse);

        PurchaseServices purchaseServices = new PurchaseServices();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(1);
        purchase.setDate_purchaseAdding("1.09.2010");
        purchase.setDate_purchaseDeleting("5.09.2010");
        purchase.setDate_purchasePayment("5.09.2010");
        purchase.setBookCount(1);
        purchase.setBookPrice(BigDecimal.valueOf(666666666));
        purchase.setBookDeleted(false);
        purchase.setBookPaid(true);
        purchase.setBook_id(1);
        purchase.setUser_id(1);
        purchaseServices.savePurchase(purchase);

        RegisteredUserRoleServices registeredUserRoleServices = new RegisteredUserRoleServices();
        RegisteredUserRole registeredUserRole = new RegisteredUserRole();
        registeredUserRole.setRegisterUserRoleId(1);
        registeredUserRole.setUser_id(1);
        registeredUserRole.setUser_type_id(1);
        registeredUserRoleServices.saveRegisteredUserRole(registeredUserRole);


        StorageServices storageServices = new StorageServices();
        Storage storage = new Storage();
        storage.setStorageId(1);
        storage.setBookId(1);
        storage.setBookCount(3900000);
        storage.setStorageStreet("Academic");
        storage.setStorageHouseNumber("9k");
        storage.setStorageFlatNumber("67j");
        storage.setCountry_id(1);
        storage.setCity_id(1);
        storageServices.saveStorage(storage);

        UserServices userServices = new UserServices();
        User user = new User();
        user.setUserId(1);
        user.setUser_name("Anna");
        user.setUser_surname("Goncharova");
        user.setUser_middle_name("Sergeevna");
        user.setUser_sex("f");
        user.setUser_email("anna@anna");
        user.setUser_username("Anna1233");
        user.setUser_password("nnnnn");
        user.setUser_birthday("12.08.2001");
        user.setUser_country_id(1);
        user.setUser_city_id(1);
        user.setUser_street("terora");
        user.setUser_house_number("45t");
        user.setUser_flat_number("12");
        user.setUser_type_id(1);
        userServices.saveUser(user);

        UserTypeServices userTypeServices = new UserTypeServices();
        UserType userType = new UserType();
        userType.setUserTypeId(1);
        userType.setUserType("admin");
        userTypeServices.saveUserType(userType);

        AccessRightsListServices accessRightsListServices = new AccessRightsListServices();
        AccessRightsList accessRightsList = new AccessRightsList();
        accessRightsList.setUserRightId(1);
        accessRightsList.setUser_type_id(1);
        accessRightsList.setRights("delete books");
        accessRightsListServices.saveAccessRightsList(accessRightsList);

    }

    private static void findEntitiesById() {
        CountriesServices countriesServices = new  CountriesServices();
        countriesServices.findCountry(1);

        CitiesServices citiesServices = new CitiesServices();
        citiesServices.findCity(1);

        AuthorServices authorServices = new AuthorServices();
        authorServices.findAuthor(1);

        BookServices bookServices = new BookServices();
        bookServices.findBooks(1);

        PublishingHouseServices publishingHouseServices = new PublishingHouseServices();
        publishingHouseServices.findPublishingHouse(1);

        PurchaseServices purchaseServices = new PurchaseServices();
        purchaseServices.findPurchase(1);

        RegisteredUserRoleServices registeredUserRoleServices = new RegisteredUserRoleServices();
        registeredUserRoleServices.findRegisteredUserRole(1);

        StorageServices storageServices = new StorageServices();
        storageServices.findStorage(1);

        UserServices userServices = new UserServices();
        userServices.findUser(1);

        UserTypeServices userTypeServices = new UserTypeServices();
        userTypeServices. findUserType(1);

        AccessRightsListServices accessRightsListServices = new AccessRightsListServices();
        accessRightsListServices.findAccessRightsList(1);
    }

    private static void findAllEntities() {

        CountriesServices countriesServices = new  CountriesServices();
        countriesServices.findAllCountries();

        CitiesServices citiesServices = new CitiesServices();
        citiesServices.findAllCities();

        AuthorServices authorServices = new AuthorServices();
        authorServices.findAllAuthors();

        BookServices bookServices = new BookServices();
        bookServices.findAllBooks();

        PublishingHouseServices publishingHouseServices = new PublishingHouseServices();
        publishingHouseServices.findAllPublishingHouses();

        PurchaseServices purchaseServices = new PurchaseServices();
        purchaseServices.findAllPurchases();

        RegisteredUserRoleServices registeredUserRoleServices = new RegisteredUserRoleServices();
        registeredUserRoleServices.findAllRegisteredUserRoles();

        StorageServices storageServices = new StorageServices();
        storageServices.findAllStorages();

        UserServices userServices = new UserServices();
        userServices.findAllUsers();

        UserTypeServices userTypeServices = new UserTypeServices();
        userTypeServices. findAllUserTypes();

        AccessRightsListServices accessRightsListServices = new AccessRightsListServices();
        accessRightsListServices.findAllAccessRightsLists();
    }

}
