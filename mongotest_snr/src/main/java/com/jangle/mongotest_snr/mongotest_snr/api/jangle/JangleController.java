package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "api/jangle")
@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class JangleController {

	private final JangleService jangleService;

	public JangleController(JangleService jangleService)
	{
		this.jangleService=jangleService;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Jangle> getCommentById(@PathVariable String id) {
		return jangleService.getById(id);

	}

	@GetMapping(params = { "page", "size" })
	public ResponseEntity<List<Jangle>> getComments2(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		return null;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Jangle jangle) {
		return jangleService.save(jangle);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		return jangleService.delete(id);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Jangle jangle) {
		return jangleService.update(id,jangle);

	}

}
