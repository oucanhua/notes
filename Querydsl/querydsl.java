-------------------
querydsl			|
-------------------
	# �ĵ�
		http://www.querydsl.com/static/querydsl/latest/reference/html_single/
	
	# Maven
		<dependency>
		    <groupId>com.querydsl</groupId>
		    <artifactId>querydsl-jpa</artifactId>
		    <version>4.2.1</version>
		</dependency>
	
		<dependency>
		    <groupId>com.querydsl</groupId>
		    <artifactId>querydsl-apt</artifactId>
		    <version>4.2.1</version>
		    <scope>provided</scope>
		</dependency>
		<plugin>
			<groupId>com.mysema.maven</groupId>
			<artifactId>apt-maven-plugin</artifactId>
			<version>1.1.3</version>
			<executions>
				<execution>
					<goals>
						<goal>process</goal>
					</goals>
					<configuration>
						<outputDirectory>target/generated-sources/java</outputDirectory>
						<processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
					</configuration>
				</execution>
			</executions>
		</plugin>


-------------------
��ѯ�������	   |
-------------------
	# ��Ҫͨ�� apt-maven-plugin �����querydsl-apt��������ɼ�����
		* ��ͬEntityע�����ʹ�ò�ͬ�����ɲ���(<processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>)
			com.querydsl.apt.jpa.JPAAnnotationProcessor					//jpa��ע��
			com.querydsl.apt.hibernate.HibernateAnnotationProcessor		//Hibernate��ע��
		
		* ʹ��maven����: mvn compile -DskipTests
		* ����Ŀ¼: target/generated-sources/java ������entityͬ���Ĳ�ѯ��(������������Q�ַ�)

	
	# ����������
		* UserEntity �������ɵļ�������
			@Generated("com.querydsl.codegen.EntitySerializer")
			public class QUserEntity extends EntityPathBase<UserEntity> {
				private static final long serialVersionUID = -1352166679L;
				public static final QUserEntity userEntity = new QUserEntity("userEntity");
				public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);
				public final NumberPath<Integer> id = createNumber("id", Integer.class);
				public final StringPath name = createString("name");
				public QUserEntity(String variable) {
					super(UserEntity.class, forVariable(variable));
				}
				public QUserEntity(Path<? extends UserEntity> path) {
					super(path.getType(), path.getMetadata());
				}
				public QUserEntity(PathMetadata metadata) {
					super(UserEntity.class, metadata);
				}
			}
		
		* �̳�: EntityPathBase<T>
		* �߱�һ�������ĳ�������, ����Entity����������ĸСд, Ҳ�����Լ����ݹ��캯������

			
		
	
-------------------
����			   |
-------------------
	package io.springboot.jpa.test;

	import io.springboot.jpa.JpaApplication;
	import io.springboot.jpa.domain.entity.QUserEntity;
	import io.springboot.jpa.domain.entity.UserEntity;

	import javax.persistence.EntityManager;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

	import com.querydsl.jpa.impl.JPAQueryFactory;

	import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

	// ��springboot��jpa������ʹ��
	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = JpaApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
	public class JpaApplicationTest {

		// ע�� entityManager
		@Autowired
		private EntityManager entityManager;

		@Test
		public void test() {

			// �Ӽ��������ȡ��ʵ��
			QUserEntity qUserEntity = QUserEntity.userEntity;

			// ���� JPAQueryFactory
			JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
			
			// ʹ�� jpaQueryFactory ����
			UserEntity userEntity = (UserEntity) jpaQueryFactory.from(qUserEntity).where(qUserEntity.name.eq("Hello")).fetchOne();

			System.out.println(userEntity);
		}
	}
