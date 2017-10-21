# TP 1 : Hello world, FizzBuzz, Fibonacci

Le but de ce TP est de vérifier le bon fonctionnement des outils nécessaires pour le cours, et de vous familiariser avec les concepts de base du développement Java.

## Mise en place

Après avoir installé un JDK (version 1.8+), Eclipse et Maven, vous allez devoir importer ce projet dans Eclipse. Pour ceci, suivez les étapes suivantes :

- *File*
- *Import...*
- Selectionner le wizard *Existing Maven Projects*
- Indiquer le dossier du projet, puis *Finish*

Le projet devrait alors être importé. Vous devriez voir, dans l'arborescence de celui-ci, deux dossiers contenant des fichiers sources :

- `src/main/java` contient les fichiers `.java` qui crééront les `.class` de l'artefact/executable final;
- `src/test/java` contient les fichiers `.java` qui crééront des `.class` servant à tester le bon fonctionnement des premiers.

## 1ère partie : Hello world

Il s'agit dans cette première partie de vérifier le bon fonctionnement de Java et d'Eclipse.
Retrouvez la classe `com.zenika.tp1.helloworld.HelloWorld`, et ouvrez la. Que fait ce programme ?
Pour compiler et exécuter, faites un clic droit sur le fichier `HelloWorld.java`, puis selectionnez *Run As* > *Java Application*.

## 2e partie : FizzBuzz

*FizzBuzz* est le nom d'un petit exercice de programmation visant à manipuler les conditions. Le principe est le suivant :

On prend en entrée un entier, et on renvoie une chaine de caractères suivant les règles suivantes :

- Si l'entier est un multiple de 3, on renvoie `Fizz`;
- Si l'entier est un multiple de 5, on renvoie `Buzz`;
- Si l'entier est à la fois un multiple de 3 et 5, on renvoie `FizzBuzz`;
- Si l'entier ne correspond à aucune des catégories ci-dessus, on renvoie une chaine vide.

Pour terminer ce TP, vous devez écrire un programme qui fait passer les tests de la classe `com.zenika.tp1.fizzbuzz.FizzBuzzerTest`. Pour cela, vous devez compléter la classe `com.zenika.tp1.fizzbuzz.FizzBuzzer`.

Pour lancer les tests, faites un clic droit sur le fichier `FizzBuzzerTest.java` puis selectionnez *Run As* > *JUnit Test*. Lorsque les tests passent, vous pouvez essayer de lancer la classe `FizzBuzz`, qui se sert de votre FizzBuzzer pour écrire les résultats de 0 à 20.

## 3e partie : Fibonacci

La suite de Fibonacci est une suite d'entiers définie de la manière suivante :

- fibonacci(0) = 0
- fibonacci(1) = 1
- Pour les éléments suivants, chaque valeur vaut la somme des deux précédentes.

Pour terminer ce TP, vous devez écrire un programme qui fait passer les tests de la classe `com.zenika.tp1.fibonacci.FibonacciComputerTest`, en completant la classe `com.zenika.tp1.fibonacci.FibonacciComputer`.

La suite de Fibonacci atteignant très vite des valeurs au-delà de ce que permettent les types `int` et `long` de Java, on va utiliser la classe `BigInteger` de la bibliothèque standard Java. Vous pouvez vous réferer à la Javadoc en ligne pour savoir comment la manipuler.
