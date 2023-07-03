package Fenix.Lodge;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LodgeService {

	private final LodgeRepository lodgeRepository;

	public LodgeService(LodgeRepository lodgeRepository) {
		this.lodgeRepository = lodgeRepository;
	}

	public void createLodge(LodgeRequest request){
		Lodge lodge = new Lodge();
		lodge.setName(request.getName());
		lodge.setRegister(request.getRegister());
		lodgeRepository.save(lodge);
	}

	public List<Lodge> getAllLodges(){
		return lodgeRepository.findAll();
	}

	public void deleteLodgeById(Integer lodgeId){
		lodgeRepository.deleteById(lodgeId);
	}

	public void updateLodge(Integer lodgeId, LodgeRequest request){
		Lodge lodge = new Lodge();
		lodge.setId(lodgeId);
		lodge.setName(request.getName());
		lodge.setRegister(request.getRegister());
		lodgeRepository.save(lodge);
	}

	public Optional<Lodge> fetchLodge(Integer lodgeId) {
		return lodgeRepository.findById(lodgeId);
	}
}
