# Ballers

## Inspiration
It is often hard to find people to play full basketball games with, and that 'NBA game moment' of yours stays just a daydream. Shooting around can be fun, but there is nothing more fun than playing a full game with the entire court buzzing. 
## What it does
With ballers, you can solve all your basketball problems, and dive into the world of local basketball! You can not only host basketball games in your nearby courts, but also join games hosted by others. With authentication, your information will be stored in your app so you could further access it and keep track of all your future games.
## How we built it
I used android studio and firebase to build the app. With android studio, I coded both the frontend and the backend. For authentication, I used firebase, and for storing and saving all user data, I used the firebase realtime database. First, to get in the information of the games, I made a hashmap that then directly was set up as a new game under the Email of the current user. To retrieve the data to show current games, I went in the Email of the current user and got all the details to display it. On the other hand, for the local games, I went through all the emails in the database to get to every single game happening around. As for the demo, I had to use Figma because my emulator kept crashing :(
## Challenges we ran into
The biggest challenge I ran into was my emulator. Ugh, just thinking about it again frustrates me. My ram is quite low, so running such a big project on the android emulator was a pain. And not only that, my android studio also kept crashing and crashing every moment. Furthermore, I had NEVER used a database, considering this is only my second hackathon, and learning it meant hours and hours of youtube videos. 
## Accomplishments that we're proud of
I am incredibly proud that I could finish such a big project alone in less than two days. On the way, there was a lot of suffering, but I am glad I can look back and say I learnt a lot. 
## What we learned
I learned how to use the firebase real-time database, including updating information and retrieving it when required. I also learned how to use authentication and not scream out every time my emulator crashed.
## What's next for Ballers
A friends feature, where you could add friends and talk to them, could see the light of the day. Also, a reminder notification that comes in an hour before a game, and a pop up question after every game to rate the game and check if won or not to keep track of the statistics on a profile page.  
