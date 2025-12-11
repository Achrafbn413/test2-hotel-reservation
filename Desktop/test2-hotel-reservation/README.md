# Test 2 - Hotel Reservation System

Voici ma solution pour le test technique 2.  
Le but était de gérer des rooms, des users et des réservations simples en Java.  
J'ai essayé de garder le code clair et conforme aux règles données dans l’énoncé.

## Classes principales

- **Room** : contient le numéro de chambre, le type et le prix par nuit.
- **User** : contient l’ID du user et son balance.
- **Booking** : représente une réservation. Je garde dans cette classe les infos de la chambre au moment de la réservation (type et prix) pour que les anciennes réservations ne changent pas si on modifie une room plus tard.
- **RoomType** : les trois types de chambres (standard, junior, suite).

### Petite explication de la classe Service

La classe `Service` gère toute la logique du système :  
- `setRoom()` crée une chambre si elle n’existe pas ou met à jour son type et son prix.  
- `setUser()` crée ou met à jour un utilisateur.  
- `bookRoom()` vérifie plusieurs choses : user existe, room existe, dates valides, chambre disponible, balance suffisante, etc. Si tout est bon, la réservation est enregistrée et le balance est mis à jour.  
- `printAll()` affiche toutes les rooms et toutes les réservations du plus récent au plus ancien.  
- `printAllUsers()` affiche les users dans l’ordre inverse de création.

J’ai suivi les consignes du PDF : utiliser des ArrayLists, ne pas impacter les anciennes réservations, gérer les erreurs, etc.

## Résultat obtenu dans le terminal

Voici ce que j’ai obtenu après avoir exécuté les tests demandés :

Not enough balance.
Invalid dates: checkIn is after checkOut.
Booking successful.
Room is already booked.
Booking successful.

===== PRINT ALL =====

--- Rooms (latest first) ---
Room 3 | SUITE | Price/night: 3000
Room 2 | JUNIOR | Price/night: 2000
Room 1 | SUITE | Price/night: 10000

--- Bookings (latest first) ---
Booking | User: 2 | Room: 3 | Type (at booking): SUITE | Price/night (at booking): 3000 |
From: Tue Jul 07 00:00:00 WEST 2026 | To: Wed Jul 08 00:00:00 WEST 2026
Booking | User: 1 | Room: 1 | Type (at booking): STANDARD | Price/night (at booking): 1000 |
From: Tue Jul 07 00:00:00 WEST 2026 | To: Wed Jul 08 00:00:00 WEST 2026

===== PRINT ALL USERS =====

--- Users (latest first) ---
User 2 | Balance: 7000
User 1 | Balance: 4000