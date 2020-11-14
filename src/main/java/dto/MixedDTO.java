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
public class MixedDTO {
    private String eName;
    private String eCity;
    private String pName;
    private String population;
    private String joke;
    private int status;

    public MixedDTO(PlanetDTO pDTO, DadDTO dDTO, EmployeeDTO eDTO) {
        this.eName = eDTO.getName();
        this.eCity = eDTO.getCity();
        this.pName = pDTO.getName();
        this.population = pDTO.getPopulation();
        this.joke = dDTO.getJoke();
        this.status = dDTO.getStatus();
                
    }
    
}
