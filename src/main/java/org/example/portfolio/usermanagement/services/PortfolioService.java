package org.example.portfolio.usermanagement.services;

import org.example.portfolio.usermanagement.entities.Portfolio;
import org.example.portfolio.usermanagement.entities.User;
import org.example.portfolio.usermanagement.mappers.PortFolioCloner;
import org.example.portfolio.usermanagement.mappers.UserCloner;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class PortfolioService {
    private static Map<String, User> userDataBase = new HashMap<>();
    Logger logger =Logger.getLogger(PortfolioService.class.getCanonicalName());
    static {
        HashMap<String,Portfolio> portfolios;
        Portfolio port;

        User user1 = new User ( );
        user1.setUsername( "Arty" );
        user1.setFirstName("Artus");
        user1.setLastName("Brown");
        user1.setPassword( "password" );
        user1.setBirthday(new Date());
        user1.setPortfolioName("Arty's Portfolio");
        user1.setReceiveJunkMail( true );

        portfolios = new HashMap<>();
        port = new Portfolio();
        port.setName( "Paintings");
        portfolios.put ( port.getName(), port );

        port = new Portfolio();
        port.setName( "Photos");
        portfolios.put ( port.getName(), port );

        user1.setPortfolios( portfolios );
        userDataBase.put( user1.getUsername(), user1 );

        User user2 = new User ( );
        user2.setUsername( "Mary" );
        user2.setFirstName("Mary");
        user2.setLastName("Greene");
        user2.setPassword( "max" );
        user2.setBirthday(new Date());
        user2.setPortfolioName("Mary's Portfolio");

        portfolios = new HashMap<>();
        port = new Portfolio();
        port.setName( "Oil Paintings");
        portfolios.put ( port.getName(), port );

        port = new Portfolio();
        port.setName( "Wood Cuts");
        portfolios.put ( port.getName(), port );

        user2.setPortfolios( portfolios );
        userDataBase.put( user2.getUsername(), user2 );

        User user3 = new User ( );
        user3.setUsername( "Jimmy" );
        user3.setFirstName("James");
        user3.setLastName("Brown");
        user3.setPassword( "jax" );
        user3.setBirthday(new Date());
        user3.setPortfolioName("Jimmy's Portfolio");
        user3.setReceiveJunkMail( true );

        portfolios = new HashMap<>();
        port = new Portfolio();
        port.setName( "Lithography");
        portfolios.put ( port.getName(), port );

        port = new Portfolio();
        port.setName( "Monotypes");
        portfolios.put ( port.getName(), port );

        user3.setPortfolios( portfolios );
        userDataBase.put( user3.getUsername(), user3 );

        User user4 = new User ( );
        user4.setUsername( "Charlie Joe" );
        user4.setFirstName("Chuck");
        user4.setLastName("English");
        user4.setPassword( "cax" );
        user4.setBirthday(new Date());
        user4.setPortfolioName("Charlie Joe's Portfolios");

        portfolios = new HashMap<>();
        port = new Portfolio();
        port.setName( "Crayola");
        portfolios.put ( port.getName(), port );

        port = new Portfolio();
        port.setName( "Impressions");
        portfolios.put ( port.getName(), port );

        user4.setPortfolios( portfolios );
        userDataBase.put( user4.getUsername(), user4 );
    }

    public boolean userExists(String userName) {
        return userDataBase.containsKey(userName);
    }

    public void createAccount(User user) {
        userDataBase.put(user.getUsername(), user);
    }

    public void addImage(File picture, String fileName, String fileSystemHome) throws IOException {
        File dir = new File(fileSystemHome);
        if (!dir.exists()) {
            dir.mkdir();
        }

        String targetPath = dir.getPath() + File.separator + fileName;
        String messageWrintingFile = String.format("writing file to %s%n",targetPath);
        logger.info(messageWrintingFile);

        File picDestination = new File(targetPath);
        try(FileInputStream in = new FileInputStream(picture)){
            try(FileOutputStream out = new FileOutputStream(picDestination)){
                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
            }
        }
    }

    public User authenticateUser(String userName, String password) {
        String messageUserAuthentication = String.format("Authenticating: userName: %s", userName);
        logger.info(messageUserAuthentication);
        User persitedUser = userDataBase.get(userName);
        User userModel = null;

        if (persitedUser != null && persitedUser.getPassword().equals(password)) {
            userModel = getModelCopy(persitedUser);

        }

        return userModel;
    }

    public void persistUser(User user) {
        String key = user.getUsername();
        boolean userExists = userDataBase.containsKey(key);
        String messageUserVerification = String.format("persisting username = %s, Key exists = %s%n", key, userExists);
        logger.info(messageUserVerification);
        String messageUserPassword = String.format("password %s%n", user.getPassword());
        logger.info(messageUserPassword);
        userDataBase.remove(user.getUsername());
        userDataBase.put(user.getUsername(), user);
    }

    public Collection<User> getUsers() {
        return  new ArrayList<>(userDataBase.values());
    }

    public Collection<Portfolio> getPortfolios() {
        List<Portfolio> portfolioList = new ArrayList<>();
        getUsers()
                .forEach(user -> portfolioList.addAll(user.getPortfolios().values()));
        return portfolioList;
    }

    public Portfolio getPortfolio(String userName, String portfolioName) {
        User user = getUser(userName);
        return user.getPortfolios().get(portfolioName);
    }

    public User getUser(String userName) {
        User persistedUser = userDataBase.get(userName);
        return getModelCopy(persistedUser);
    }

    public String getDefaultUsers() {
      return   getUsers()
              .stream()
              .findAny()
              .orElse(new User()).getUsername();
    }

    private User getModelCopy(User userModel) {
        User userCloned = UserCloner.MAPPER.clone(userModel);
        userCloned.setPortfolios(new HashMap<>(userModel.getPortfolios()));
        userCloned.setPortfolios(new HashMap<>());
        userModel
                .getPortfolios()
                .forEach((portfolioName, portfolio) -> userCloned.getPortfolios().put(portfolioName,PortFolioCloner.MAPPER.clone(portfolio)) );

        return userCloned;
    }
}
