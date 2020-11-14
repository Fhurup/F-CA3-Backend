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
public class CombinedDTO {
    private String cJoke;
    private String cJokeID;
    private String dJoke;
    private String dJokeID;
    

    public CombinedDTO(ChuckDTO chuckDTO, DadDTO dadDTO) {
        this.cJoke = chuckDTO.getValue();
        this.cJokeID = chuckDTO.getId();
        this.dJoke = dadDTO.getJoke();
        this.dJokeID = dadDTO.getId();
    }
    
    
}
