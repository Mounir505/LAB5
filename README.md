# README.md - Lab 5 : Convertisseur d'Unités (Tabs & Fragments)

## 📌 Présentation du Projet
Ce projet est une application Android développée en **Java** illustrant l'utilisation des composants **TabLayout** et **ViewPager2**. L'objectif est de fournir une interface moderne et fluide (Material Design 3) pour convertir des unités de distance et de température, tout en gérant les erreurs de saisie.

---

## 📸 Galerie Proof of Concept (PoC)

Voici les preuves visuelles du bon fonctionnement de l'application, couvrant les erreurs de saisie et les conversions dans les deux sens pour chaque unité.

| Erreur Distance | Celsius vers Fahrenheit | Kilomètres vers Miles |
| :---: | :---: | :---: |
| <img width="1080" height="2424" alt="distance_missed" src="https://github.com/user-attachments/assets/ca1db5e0-d8bc-4a63-ae9e-0ef810992f36" /> | <img width="1080" height="2424" alt="C_to_F" src="https://github.com/user-attachments/assets/2a94741d-ebab-4168-ba30-96daffaa5f65" /> | <img width="1080" height="2424" alt="Km_to_Miles" src="https://github.com/user-attachments/assets/0d99e640-bb64-4829-ad7a-3285a9a354a2" /> |
| **Erreur Température** | **Fahrenheit vers Celsius** | **Miles vers Kilomètres** |
| <img width="1080" height="2424" alt="temperature_missed" src="https://github.com/user-attachments/assets/95a619d6-4c9b-4c6d-8e42-e499ad9768f0" /> | <img width="1080" height="2424" alt="F_to_C" src="https://github.com/user-attachments/assets/c515c922-26d2-4997-bbfd-817279b7f7a5" /> | <img width="1080" height="2424" alt="Miles_to_Km" src="https://github.com/user-attachments/assets/bda84600-25bb-4219-8c63-80beab778b71" /> |

---

## 📂 Structure du Projet
Le projet est organisé selon l'architecture standard d'Android :

```text
ConverterTabsJava/
├── app/
│   ├── src/main/java/local/mounir/convertertabsjava/
│   │   ├── MainActivity.java        # Activité principale (Gestion des Onglets)
│   │   ├── ViewPagerAdapter.java    # Adaptateur pour lier les Fragments
│   │   ├── DistanceFragment.java    # Logique de conversion Distance
│   │   └── TemperatureFragment.java # Logique de conversion Température
│   ├── src/main/res/layout/
│   │   ├── activity_main.xml        # Layout avec TabLayout et ViewPager2
│   │   ├── fragment_distance.xml    # Interface utilisateur Distance
│   │   └── fragment_temp.xml        # Interface utilisateur Température

```

## 🛠️ Fonctionnalités et Logique de Code
1. Navigation par Onglets (MainActivity.java)

La navigation est gérée par un ViewPager2 et synchronisée avec un TabLayout via TabLayoutMediator.

Extrait clé :

```text
new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
    if (position == 0) tab.setText("Distance");
    else tab.setText("Température");
}).attach();

```
2. Gestion des Erreurs (Validation)

L'application vérifie si l'utilisateur a saisi une valeur avant de tenter la conversion. Si le champ est vide, un message d'erreur s'affiche directement sur le composant TextInputLayout grâce à la méthode .setError().

3. Conversion de Température (TemperatureFragment.java)

Ce fragment permet de convertir les degrés en fonction du bouton sélectionné dans le groupe.

Logique de calcul :

```text
if (toggleGroup.getCheckedButtonId() == R.id.btnCtoF) {
    result = (val * 9/5) + 32; // Celsius vers Fahrenheit
} else {
    result = (val - 32) * 5/9; // Fahrenheit vers Celsius
}
```
4. Conversion de Distance (DistanceFragment.java)

Ce fragment gère la conversion entre Kilomètres et Miles.

Logique de calcul :

```text
if (toggleGroup.getCheckedButtonId() == R.id.btnKmToMiles) {
    result = val * 0.621371; // Km vers Miles
} else {
    result = val / 0.621371; // Miles vers Km
}
```
## 🎨 Interface Utilisateur (UI)
L'interface respecte les standards Material 3 :

MaterialCardView : Pour regrouper les éléments de manière élégante avec des bordures et ombres subtiles.

MaterialButtonToggleGroup : Pour une sélection intuitive et moderne du sens de conversion.

TextInputLayout (style OutlinedBox) : Pour une saisie de texte claire avec gestion visuelle des erreurs intégrée.

## 🚀 Installation et Test
Cloner ou télécharger le dépôt.

Ouvrir le projet dans Android Studio (version recommandée : Jellyfish ou supérieure).

Laisser Gradle se synchroniser.

Lancer l'application sur un émulateur ou un appareil physique (API 24+).
