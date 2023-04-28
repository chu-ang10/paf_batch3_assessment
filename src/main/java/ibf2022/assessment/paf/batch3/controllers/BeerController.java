package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeerController {

	@Autowired
	BeerRepository beerRepository;
	// TODO Task 2 - view 0

	@GetMapping(path = "/")
	public String goToLanding(Model model) {
		List<Style> listOfStyles = beerRepository.getStyles();
		model.addAttribute("styles", listOfStyles);
		return "view0";
	}

	// TODO Task 3 - view 1

	@GetMapping(path = "{/beer/style/{styleId}")
	public String retrieveBreweriesByBeer(Model model, @RequestParam String styleId) {
		List<Beer> BreweriesByBeer = beerRepository.getBreweriesByBeer();
		model.addAttribute("beer", BreweriesByBeer);
		return "view1";
	}

	// TODO Task 4 - view 2
	@GetMapping(path = "{/beer/brewery/{breweryId}")
	public String getBeersFromBrewery(Model model, @RequestParam String breweryId) {
		Optional<Brewery> beerFromBrewery = beerRepository.getBeersFromBrewery();
		model.addAttribute("beer", beerFromBrewery);
		return "view2";
	}

	// TODO Task 5 - view 2, place order
	@PostMapping(value = "/brewery/{breweryId}/order")
	public String placeOrder(@PathVariable Integer breweryId, @RequestBody String order) {

		return "view3";
	}

}
