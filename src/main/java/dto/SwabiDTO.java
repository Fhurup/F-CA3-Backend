/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author fh
 */
public class SwabiDTO {
    private String SpaceShipName;
    private String SpaceShipModel;
    private String PersonName;
    private String PersonGender;
    private String planetName;
    private String planetPopulation;

    public SwabiDTO(SpaceShipDTO spaceShip, PersonDTO person, PlanetDTO planet) {
        this.SpaceShipName = spaceShip.getName();
        this.SpaceShipModel = spaceShip.getModel();
        this.PersonName = person.getName();
        this.PersonGender = person.getGender();
        this.planetName = planet.getName();
        this.planetPopulation = planet.getPopulation();
    }
    
    
}
