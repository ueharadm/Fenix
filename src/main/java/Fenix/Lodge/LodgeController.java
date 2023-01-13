package Fenix.Lodge;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/lodge")
public class LodgeController {
	
	private static List<Lodge> lodgeList= new ArrayList<Lodge>();
	private static Integer lastLodgeId = 0;
	
	public static void createNewLodge(String lodgeName) {
		Integer nextLodgeId = lastLodgeId+1;
		lodgeList.add(new Lodge(nextLodgeId, lodgeName));
	}
	
	public static boolean lodgeExistsByUid(Integer lodgeUid) {
		for (Lodge lodge : lodgeList) {
			if(LodgeService.compareLodgeIdWithInteger(lodge, lodgeUid)) {
				return true;
			}
		}
		return false;
	}

	public static List<Lodge> getLodgeList(){
		return Collections.unmodifiableList(lodgeList);
	}
	
}
