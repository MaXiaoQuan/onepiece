package priv.mq.onePiece.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.mq.onePiece.dao.IopDao;
import priv.mq.onePiece.entities.Figure;

@Service
public class FigureService {

	@Autowired
	private IopDao<Figure> iopDao;
	
	public void saveFigure(Figure figure) {
		iopDao.save(figure);
	}

}
