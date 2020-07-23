package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		return randomQuote(repository.findAll());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		return randomQuote(repository.findAllByActor(actor));
	}

	private Quote randomQuote(List<Quote> quoteList){
		return quoteList.get(new Random().nextInt(quoteList.size()));
	}
}
