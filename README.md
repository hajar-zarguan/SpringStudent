# <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> SpringStudent : Application Web basée sur Spring MVC, Spring Data JPA et Spring Security qui permet de gérer des étudiants.
![Java](https://img.shields.io/badge/-Java-333333?style=flat&logo=Java&logoColor=007396)
![SpringBoot](https://img.shields.io/badge/-Spring%20Boot-333333?style=flat&logo=spring-boot)

## 🔗 La démonstration video est disponible sur YOUTUBE
[cliquez-ici](https://youtu.be/MCT1qpOZcbo)


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table de matière</summary>
  <ol>
    <li>
      <a href="#Lesnotions">Les notions et les techniques</a>
      <ul>
        <li><a href="#Spring-Web-MVC">Spring Web MVC</a></li>
       <li><a href="#built-with">Spring Security</a></li>
       <li><a href="#built-with">Spring Data JPA</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Démonstration</a>
      <ul>
        <li><a href="#prerequisites">en tant que administrateur</a></li>
        <li><a href="#installation">en tant q'un simple utilisateur</a></li>
      </ul>
    </li>
    <li><a href="#usage">Structure du projet</a></li>
   
  </ol>
</details>


## 1. Les notions et les techniques 
Les notions et les techniques que nous avons pratiqué dans cette activité 

<a href="https://getbootstrap.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a>
### - Spring Web MVC 
Spring Web MVC est le module Spring consacré au développement d’application Web et d’API Web. Le nom de ce module renvoie directement au modèle MVC (Modèle Vue Contrôleur). Le modèle MVC n’est pas réservé au développement Web et même, son application n’a pas vraiment de sens pour le développement d’API Web. Quoi qu’il en soit, les notions de modèle, de contrôleur et de vue sont centrales pour Spring Web MVC. Dans ce chapitre, nous rappellerons le principe du modèle MVC et nous verrons comment intégrer Spring Web MVC dans une application Spring Boot et dans une application sans Spring Boot.
### - Spring Security
Spring Security est un Framework de sécurité léger qui fournit une authentification et un support d’autorisation afin de sécuriser les applications Spring. Il est livré avec des implémentations d’algorithmes de sécurité populaires.
### - Spring Data JPA
Spring Data est un projet Spring qui a pour objectif de simplifier l’interaction avec différents systèmes de stockage de données : qu’il s’agisse d’une base de données relationnelle, d’une base de données NoSQL, d’un système Big Data ou encore d’une API Web.Le principe de Spring Data est d’éviter aux développeurs de coder les accès à ces systèmes. Pour cela, Spring Data utilise une convention de nommage des méthodes d’accès pour exprimer la requête à réaliser.




## :mag_right: Démonstration 
### Acceuil
![image](https://user-images.githubusercontent.com/82539023/163667008-474f0f9a-6a34-42a9-a5e6-ed94b9abfb35.png)
![image](https://user-images.githubusercontent.com/82539023/163667040-fb14a906-2fd5-4427-b814-4ca72d9b2872.png)


### Sign In as admin
![image](https://user-images.githubusercontent.com/82539023/163666731-bbd0a838-0190-4385-9c15-48dd92f192ee.png)

#### liste des étudiants 
![image](https://user-images.githubusercontent.com/82539023/163666775-0068a490-7ea5-4406-995c-68d9857654ac.png)

##### suppression
![image](https://user-images.githubusercontent.com/82539023/163666791-d37380b0-ad40-4473-a332-4e12b1a339fd.png)

#### L'ajout
![image](https://user-images.githubusercontent.com/82539023/163666978-86206c5b-ee68-4447-8b9b-31d135df4d72.png)

#### Modification
![image](https://user-images.githubusercontent.com/82539023/163666825-9720ca9a-0419-4f00-846c-2d6e14292c7e.png)

#### Info etudiant
![image](https://user-images.githubusercontent.com/82539023/163666876-6ee49e25-5b66-4c6d-a405-7cfa5f7c48a4.png)

#### navbar
![image](https://user-images.githubusercontent.com/82539023/163667247-2f5bdcd2-be0b-41ea-8aef-f8efab2827a7.png)



### Logout
![image](https://user-images.githubusercontent.com/82539023/163667115-dc49a6e4-0c18-4a45-a1b1-dbba5b7c81f0.png)

### Sign as user
![image](https://user-images.githubusercontent.com/82539023/163667135-76190774-ee7c-4966-8b9c-75574443686a.png)

#### liste des étudiants 
![image](https://user-images.githubusercontent.com/82539023/163667166-aa33691c-de10-4e0c-bdbf-f3013bab9c77.png)
 
#### navbar
![image](https://user-images.githubusercontent.com/82539023/163667203-34f54d70-d5b7-4112-a52d-ab403420873e.png)




### Structure du projet
#### Chaque étudiant est défini par:
 - Son id
 - Son nom
 - Son prénom
 - Son email
 - Sa date naissance
 - Son genre : MASCULIN ou FEMININ
 - Un attribut qui indique si il est en règle ou non
 
 ![image](https://user-images.githubusercontent.com/82539023/163737331-d4d4fb74-814a-4c95-8a3b-6e0472f1d409.png)

 
#### L'application a les fonctionnalités suivantes :

  - Chercher des étudiants par nom
 
  ![image](https://user-images.githubusercontent.com/82539023/163738075-3583019b-92f7-4673-a7a5-f470380b04ce.png)

  - Faire la pagination
  ![image](https://user-images.githubusercontent.com/82539023/163737755-530f4c80-0341-46a9-ba0f-cdf5ae78cf87.png)

  - Editer et mettre à jour des étudiants
  ![image](https://user-images.githubusercontent.com/82539023/163737600-f95f5bfc-ce82-4e6c-b99f-a5dd2930835f.png)
  
  - Créer une page template 
  ![image](https://user-images.githubusercontent.com/82539023/163737689-b4bd332c-8ea6-436f-931c-cfc0ae300f07.png)

  - Sécuriser l'accès à l'application avec un système d'authentification basé sur Spring security en utilisant la stratégie UseDetails Service
  ![image](https://user-images.githubusercontent.com/82539023/163737406-525b2dc9-0c5d-417e-a4ad-c51c07cda0fb.png)







