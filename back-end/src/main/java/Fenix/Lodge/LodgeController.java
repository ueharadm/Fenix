package Fenix.Lodge;

import Fenix.Lodge.Lodge;
import Fenix.Lodge.LodgeRequest;
import Fenix.Lodge.LodgeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/lodge")
@AllArgsConstructor
public class LodgeController {

	private final LodgeService lodgeService;

	@PostMapping
	public void addLodge(@RequestBody LodgeRequest request){
		lodgeService.createLodge(request);
	}

	@GetMapping
	public List<Lodge> gettAll(){
		return lodgeService.getAllLodges();
	}

	@GetMapping("{lodgeId}")
	public Optional<Lodge> fetchLodge(@PathVariable("lodgeId") Integer lodgeId){
		return lodgeService.fetchLodge(lodgeId);
	}

	@DeleteMapping("{lodgeId}")
	public void deleteLodge(@PathVariable("lodgeId") Integer lodgeId){
		lodgeService.deleteLodgeById(lodgeId);
	}

	@PutMapping("{lodgeId}")
	public void updateLodge(@PathVariable("lodgeId") Integer lodgeId,@RequestBody LodgeRequest request){
		lodgeService.updateLodge(lodgeId, request);
	}
}
