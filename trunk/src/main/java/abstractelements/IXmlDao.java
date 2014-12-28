package abstractelements;

import java.io.Serializable;
import java.util.List;

/**
 * @author dmitry_zhivushko
 * @since Sep 28, 2014
 */
public interface IXmlDao<E> extends Serializable {

	void saveNew(E entity);

	void update(E entity);

	E get(String login);

	List<E> getAll();

	void delete(String login);
}
