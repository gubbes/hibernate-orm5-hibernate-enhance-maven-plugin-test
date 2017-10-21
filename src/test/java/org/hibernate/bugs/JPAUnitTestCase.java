package org.hibernate.bugs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Book book = Book.of("978-1118063330", "Operating System Concepts 9th Edition");
		Author one = Author.of("Abraham","Silberschatz");
		book.addAuthor(one);
		Author two = Author.of("Peter","Galvin");
		book.addAuthor(two);
		Author three = Author.of("Greg","Gagne");
		book.addAuthor(three);

		entityManager.persist(book);
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		//merge detached object
		entityManager.merge(book);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
