package jokefetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ChuckDTO;
import dto.CombinedDTO;
import dto.DadDTO;
import dto.EmployeeDTO;
import dto.MixedDTO;
import dto.PersonDTO;
import dto.PlanetDTO;
import dto.SpaceShipDTO;
import dto.SwabiDTO;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import utils.HttpUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JokeFetcher {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public CombinedDTO getJokes() throws IOException {
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckDTO chuckDTO = GSON.fromJson(chuck, ChuckDTO.class);

        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadDTO dadDTO = GSON.fromJson(dad, DadDTO.class);

        CombinedDTO cDTO = new CombinedDTO(chuckDTO, dadDTO);

        return cDTO;
    }

    public SwabiDTO getSwabi() throws IOException {

        String person = HttpUtils.fetchData("https://swapi.dev/api/people/1/");
        String planet = HttpUtils.fetchData("https://swapi.dev/api/planets/1/");
        String spaceship = HttpUtils.fetchData("https://swapi.dev/api/starships/9/");

        PersonDTO pDTO = GSON.fromJson(person, PersonDTO.class);
        PlanetDTO planetDTO = GSON.fromJson(planet, PlanetDTO.class);
        SpaceShipDTO sDTO = GSON.fromJson(spaceship, SpaceShipDTO.class);

        SwabiDTO swabiDTO = new SwabiDTO(sDTO, pDTO, planetDTO);

        return swabiDTO;
    }

    public MixedDTO getMixed(ExecutorService threadPool) throws IOException, InterruptedException, ExecutionException, TimeoutException {

        Callable<DadDTO> dadTask = new Callable<DadDTO>() {
            @Override
            public DadDTO call() throws IOException {
                String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
                DadDTO dadDTO = GSON.fromJson(dad, DadDTO.class);
                return dadDTO;
            }
        };

        Callable<PlanetDTO> planetTask = new Callable<PlanetDTO>() {
            @Override
            public PlanetDTO call() throws IOException {
                String planet = HttpUtils.fetchData("https://swapi.dev/api/planets/1/");
                PlanetDTO planetDTO = GSON.fromJson(planet, PlanetDTO.class);
                return planetDTO;
            }
        };

        Callable<EmployeeDTO> employeeTask = new Callable<EmployeeDTO>() {
            @Override
            public EmployeeDTO call() throws IOException {
                String employee = HttpUtils.fetchData("https://api.mocki.io/v1/ce5f60e2");
                EmployeeDTO employeeDTO = GSON.fromJson(employee, EmployeeDTO.class);
                return employeeDTO;
            }
        };

        Future<DadDTO> futureDad = threadPool.submit(dadTask);
        Future<PlanetDTO> futurePlanet = threadPool.submit(planetTask);
        Future<EmployeeDTO> futureEmployee = threadPool.submit(employeeTask);
        
        DadDTO dad = futureDad.get(3, TimeUnit.SECONDS);
        PlanetDTO planet = futurePlanet.get(3, TimeUnit.SECONDS);
        EmployeeDTO employee = futureEmployee.get(3, TimeUnit.SECONDS);

        MixedDTO mDTO = new MixedDTO(planet, dad, employee);
        return mDTO;

    }

}

//    public MixedDTO getMixed(ExecutorService threadPool) throws IOException{
//
//        String employee = HttpUtils.fetchData("https://api.mocki.io/v1/ce5f60e2");
//        String planet = HttpUtils.fetchData("https://swapi.dev/api/planets/1/");
//        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
//
//        DadDTO dadDTO = GSON.fromJson(dad, DadDTO.class);
//        PlanetDTO planetDTO = GSON.fromJson(planet, PlanetDTO.class);
//        EmployeeDTO employeeDTO = GSON.fromJson(employee, EmployeeDTO.class);
//
//        MixedDTO mDTO = new MixedDTO(planetDTO, dadDTO, employeeDTO);
//        return mDTO;
//
//    }
