package com.codekinian.themovieapps.utils

import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv

object DataDummy {

    fun generateMovies(): List<Movie> {
        return listOf(
            Movie(
                1,
                "R.drawable.movie_a_start_is_born",
                "A Star Is Born",
                "2018-10-05",
                "Seasoned musician Jackson Maine discovers — and…",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75"
            ),
            Movie(
                2,
                "R.drawable.movie_alita",
                "Alita: Battle Angle",
                "2019-01-31",
                "When Alita awakens with no memory of who she is in…",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "69"
            ),
            Movie(
                3,
                "R.drawable.movie_aquaman",
                "Aquaman",
                "2018-12-07",
                "Once home to the most advanced civilization on Earth...",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "68"
            ),
            Movie(
                4,
                "R.drawable.movie_bohemian",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Singer Freddie Mercury, guitarist Brian May...",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80"
            ),
            Movie(
                5,
                "R.drawable.movie_cold_persuit",
                "Cold Persuit",
                "2019-02-07",
                "The quiet family life of Nels Coxman, a snowplow...",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "54"
            ),
            Movie(
                6,
                "R.drawable.movie_creed",
                "Creed",
                "2015-11-25",
                "The former World Heavyweight Champion Rocky Balboa...",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "74"
            ),
            Movie(
                7,
                "R.drawable.movie_crimes",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Gellert Grindelwald has escaped imprisonment and has...",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "68"
            ),
            Movie(
                8,
                "R.drawable.movie_glass",
                "Glass",
                "2019-01-16",
                "In a series of escalating encounters, former security...",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "65"
            ),
            Movie(
                9,
                "R.drawable.movie_how_to_train",
                "How To Train Your Dragon: The Hidden World",
                "2019-01-03",
                "As Hiccup fulfills his dream of creating a peaceful...",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "77"
            ),
            Movie(
                10,
                "R.drawable.movie_infinity_war",
                "Avengers: Infinity War",
                "2018-04-25",
                "As the Avengers and their allies have continued to...",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83"
            )
        )
    }

    fun generateDummyNowPlaying(): List<NowPlaying> {
        return listOf(
            NowPlaying(
                1,
                "R.drawable.movie_a_start_is_born",
                "A Star Is Born",
                "2018-10-05",
                "Seasoned musician Jackson Maine discovers — and…",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75"
            ),
            NowPlaying(
                2,
                "R.drawable.movie_alita",
                "Alita: Battle Angle",
                "2019-01-31",
                "When Alita awakens with no memory of who she is in…",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "69"
            ),
            NowPlaying(
                3,
                "R.drawable.movie_aquaman",
                "Aquaman",
                "2018-12-07",
                "Once home to the most advanced civilization on Earth...",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "68"
            ),
            NowPlaying(
                4,
                "R.drawable.movie_bohemian",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Singer Freddie Mercury, guitarist Brian May...",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80"
            ),
            NowPlaying(
                5,
                "R.drawable.movie_cold_persuit",
                "Cold Persuit",
                "2019-02-07",
                "The quiet family life of Nels Coxman, a snowplow...",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "54"
            ),
            NowPlaying(
                6,
                "R.drawable.movie_creed",
                "Creed",
                "2015-11-25",
                "The former World Heavyweight Champion Rocky Balboa...",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "74"
            ),
            NowPlaying(
                7,
                "R.drawable.movie_crimes",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Gellert Grindelwald has escaped imprisonment and has...",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "68"
            ),
            NowPlaying(
                8,
                "R.drawable.movie_glass",
                "Glass",
                "2019-01-16",
                "In a series of escalating encounters, former security...",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "65"
            ),
            NowPlaying(
                9,
                "R.drawable.movie_how_to_train",
                "How To Train Your Dragon: The Hidden World",
                "2019-01-03",
                "As Hiccup fulfills his dream of creating a peaceful...",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "77"
            ),
            NowPlaying(
                10,
                "R.drawable.movie_infinity_war",
                "Avengers: Infinity War",
                "2018-04-25",
                "As the Avengers and their allies have continued to...",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83"
            )
        )
    }

    fun generateDummyPopularMovie(): List<PopularMovie> {
        return listOf(
            PopularMovie(
                1,
                "R.drawable.movie_a_start_is_born",
                "A Star Is Born",
                "2018-10-05",
                "Seasoned musician Jackson Maine discovers — and…",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75"
            ),
            PopularMovie(
                2,
                "R.drawable.movie_alita",
                "Alita: Battle Angle",
                "2019-01-31",
                "When Alita awakens with no memory of who she is in…",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "69"
            ),
            PopularMovie(
                3,
                "R.drawable.movie_aquaman",
                "Aquaman",
                "2018-12-07",
                "Once home to the most advanced civilization on Earth...",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "68"
            ),
            PopularMovie(
                4,
                "R.drawable.movie_bohemian",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Singer Freddie Mercury, guitarist Brian May...",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80"
            ),
            PopularMovie(
                5,
                "R.drawable.movie_cold_persuit",
                "Cold Persuit",
                "2019-02-07",
                "The quiet family life of Nels Coxman, a snowplow...",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "54"
            ),
            PopularMovie(
                6,
                "R.drawable.movie_creed",
                "Creed",
                "2015-11-25",
                "The former World Heavyweight Champion Rocky Balboa...",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "74"
            ),
            PopularMovie(
                7,
                "R.drawable.movie_crimes",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Gellert Grindelwald has escaped imprisonment and has...",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "68"
            ),
            PopularMovie(
                8,
                "R.drawable.movie_glass",
                "Glass",
                "2019-01-16",
                "In a series of escalating encounters, former security...",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "65"
            ),
            PopularMovie(
                9,
                "R.drawable.movie_how_to_train",
                "How To Train Your Dragon: The Hidden World",
                "2019-01-03",
                "As Hiccup fulfills his dream of creating a peaceful...",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "77"
            ),
            PopularMovie(
                10,
                "R.drawable.movie_infinity_war",
                "Avengers: Infinity War",
                "2018-04-25",
                "As the Avengers and their allies have continued to...",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83"
            )
        )
    }

    fun generateDummyUpcoming(): List<Upcoming> {
        return listOf(
            Upcoming(
                1,
                "R.drawable.movie_a_start_is_born",
                "A Star Is Born",
                "2018-10-05",
                "Seasoned musician Jackson Maine discovers — and…",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75"
            ),
            Upcoming(
                2,
                "R.drawable.movie_alita",
                "Alita: Battle Angle",
                "2019-01-31",
                "When Alita awakens with no memory of who she is in…",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "69"
            ),
            Upcoming(
                3,
                "R.drawable.movie_aquaman",
                "Aquaman",
                "2018-12-07",
                "Once home to the most advanced civilization on Earth...",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "68"
            ),
            Upcoming(
                4,
                "R.drawable.movie_bohemian",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Singer Freddie Mercury, guitarist Brian May...",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80"
            ),
            Upcoming(
                5,
                "R.drawable.movie_cold_persuit",
                "Cold Persuit",
                "2019-02-07",
                "The quiet family life of Nels Coxman, a snowplow...",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "54"
            ),
            Upcoming(
                6,
                "R.drawable.movie_creed",
                "Creed",
                "2015-11-25",
                "The former World Heavyweight Champion Rocky Balboa...",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "74"
            ),
            Upcoming(
                7,
                "R.drawable.movie_crimes",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Gellert Grindelwald has escaped imprisonment and has...",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "68"
            ),
            Upcoming(
                8,
                "R.drawable.movie_glass",
                "Glass",
                "2019-01-16",
                "In a series of escalating encounters, former security...",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "65"
            ),
            Upcoming(
                9,
                "R.drawable.movie_how_to_train",
                "How To Train Your Dragon: The Hidden World",
                "2019-01-03",
                "As Hiccup fulfills his dream of creating a peaceful...",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "77"
            ),
            Upcoming(
                10,
                "R.drawable.movie_infinity_war",
                "Avengers: Infinity War",
                "2018-04-25",
                "As the Avengers and their allies have continued to...",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83"
            )
        )
    }

    fun generateDummyTvShow(): List<Tvshow> {
        return listOf(
            Tvshow(
                1,
                "R.drawable.tv_arrow",
                "The Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing…",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "59"
            ),
            Tvshow(
                2,
                "R.drawable.tv_iron_fist",
                "Marvel's Iron Fist",
                "2017-03-17",
                "Danny Rand resurfaces 15 years after being presumed…",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "61"
            ),
            Tvshow(
                3,
                "R.drawable.tv_dragon_ball",
                "Dragon Ball",
                "1986-02-26",
                "Long ago in the mountains, a fighting master known...",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "73"
            ),
            Tvshow(
                4,
                "R.drawable.tv_fairytail",
                "Fairy Tail",
                "2009-10-12",
                "Lucy is a 17-year-old girl, who wants to be a full...",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "67"
            ),
            Tvshow(
                5,
                "R.drawable.tv_family_guy",
                "Family Guy",
                "1999-01-31",
                "Sick, twisted, politically incorrect and Freakin...",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "66"
            ),
            Tvshow(
                6,
                "R.drawable.tv_flash",
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm...",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "69"
            ),
            Tvshow(
                7,
                "R.drawable.tv_naruto_shipudden",
                "Naruto Shippūden",
                "2007-02-15",
                "Naruto Shippuuden is the continuation of the original...",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "79"
            ),
            Tvshow(
                8,
                "R.drawable.tv_gotham",
                "Gotham",
                "2014-09-22",
                "Everyone knows the name Commissioner Gordon. He is one...",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "70"
            ),
            Tvshow(
                9,
                "R.drawable.tv_grey_anatomy",
                "Grey's Anatomy",
                "2005-03-27",
                "Follows the personal and professional lives of a group...",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "67"
            ),
            Tvshow(
                10,
                "R.drawable.tv_hanna",
                "Hanna",
                "2019-03-28",
                "This thriller and coming-of-age drama follows the journey...",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "70"
            )
        )
    }

    fun generateDummyAiringToday(): List<AiringToday> {
        return listOf(
            AiringToday(
                1,
                "R.drawable.tv_arrow",
                "The Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing…",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "59"
            ),
            AiringToday(
                2,
                "R.drawable.tv_iron_fist",
                "Marvel's Iron Fist",
                "2017-03-17",
                "Danny Rand resurfaces 15 years after being presumed…",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "61"
            ),
            AiringToday(
                3,
                "R.drawable.tv_dragon_ball",
                "Dragon Ball",
                "1986-02-26",
                "Long ago in the mountains, a fighting master known...",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "73"
            ),
            AiringToday(
                4,
                "R.drawable.tv_fairytail",
                "Fairy Tail",
                "2009-10-12",
                "Lucy is a 17-year-old girl, who wants to be a full...",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "67"
            ),
            AiringToday(
                5,
                "R.drawable.tv_family_guy",
                "Family Guy",
                "1999-01-31",
                "Sick, twisted, politically incorrect and Freakin...",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "66"
            ),
            AiringToday(
                6,
                "R.drawable.tv_flash",
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm...",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "69"
            ),
            AiringToday(
                7,
                "R.drawable.tv_naruto_shipudden",
                "Naruto Shippūden",
                "2007-02-15",
                "Naruto Shippuuden is the continuation of the original...",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "79"
            ),
            AiringToday(
                8,
                "R.drawable.tv_gotham",
                "Gotham",
                "2014-09-22",
                "Everyone knows the name Commissioner Gordon. He is one...",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "70"
            ),
            AiringToday(
                9,
                "R.drawable.tv_grey_anatomy",
                "Grey's Anatomy",
                "2005-03-27",
                "Follows the personal and professional lives of a group...",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "67"
            ),
            AiringToday(
                10,
                "R.drawable.tv_hanna",
                "Hanna",
                "2019-03-28",
                "This thriller and coming-of-age drama follows the journey...",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "70"
            )
        )
    }

    fun generateDummyOnTheAir(): List<OnTheAir> {
        return listOf(
            OnTheAir(
                1,
                "R.drawable.tv_arrow",
                "The Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing…",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "59"
            ),
            OnTheAir(
                2,
                "R.drawable.tv_iron_fist",
                "Marvel's Iron Fist",
                "2017-03-17",
                "Danny Rand resurfaces 15 years after being presumed…",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "61"
            ),
            OnTheAir(
                3,
                "R.drawable.tv_dragon_ball",
                "Dragon Ball",
                "1986-02-26",
                "Long ago in the mountains, a fighting master known...",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "73"
            ),
            OnTheAir(
                4,
                "R.drawable.tv_fairytail",
                "Fairy Tail",
                "2009-10-12",
                "Lucy is a 17-year-old girl, who wants to be a full...",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "67"
            ),
            OnTheAir(
                5,
                "R.drawable.tv_family_guy",
                "Family Guy",
                "1999-01-31",
                "Sick, twisted, politically incorrect and Freakin...",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "66"
            ),
            OnTheAir(
                6,
                "R.drawable.tv_flash",
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm...",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "69"
            ),
            OnTheAir(
                7,
                "R.drawable.tv_naruto_shipudden",
                "Naruto Shippūden",
                "2007-02-15",
                "Naruto Shippuuden is the continuation of the original...",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "79"
            ),
            OnTheAir(
                8,
                "R.drawable.tv_gotham",
                "Gotham",
                "2014-09-22",
                "Everyone knows the name Commissioner Gordon. He is one...",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "70"
            ),
            OnTheAir(
                9,
                "R.drawable.tv_grey_anatomy",
                "Grey's Anatomy",
                "2005-03-27",
                "Follows the personal and professional lives of a group...",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "67"
            ),
            OnTheAir(
                10,
                "R.drawable.tv_hanna",
                "Hanna",
                "2019-03-28",
                "This thriller and coming-of-age drama follows the journey...",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "70"
            )
        )
    }

    fun generateDummyPopularTv(): List<PopularTv> {
        return listOf(
            PopularTv(
                1,
                "R.drawable.tv_arrow",
                "The Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing…",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "59"
            ),
            PopularTv(
                2,
                "R.drawable.tv_iron_fist",
                "Marvel's Iron Fist",
                "2017-03-17",
                "Danny Rand resurfaces 15 years after being presumed…",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "61"
            ),
            PopularTv(
                3,
                "R.drawable.tv_dragon_ball",
                "Dragon Ball",
                "1986-02-26",
                "Long ago in the mountains, a fighting master known...",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "73"
            ),
            PopularTv(
                4,
                "R.drawable.tv_fairytail",
                "Fairy Tail",
                "2009-10-12",
                "Lucy is a 17-year-old girl, who wants to be a full...",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "67"
            ),
            PopularTv(
                5,
                "R.drawable.tv_family_guy",
                "Family Guy",
                "1999-01-31",
                "Sick, twisted, politically incorrect and Freakin...",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "66"
            ),
            PopularTv(
                6,
                "R.drawable.tv_flash",
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm...",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "69"
            ),
            PopularTv(
                7,
                "R.drawable.tv_naruto_shipudden",
                "Naruto Shippūden",
                "2007-02-15",
                "Naruto Shippuuden is the continuation of the original...",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "79"
            ),
            PopularTv(
                8,
                "R.drawable.tv_gotham",
                "Gotham",
                "2014-09-22",
                "Everyone knows the name Commissioner Gordon. He is one...",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "70"
            ),
            PopularTv(
                9,
                "R.drawable.tv_grey_anatomy",
                "Grey's Anatomy",
                "2005-03-27",
                "Follows the personal and professional lives of a group...",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "67"
            ),
            PopularTv(
                10,
                "R.drawable.tv_hanna",
                "Hanna",
                "2019-03-28",
                "This thriller and coming-of-age drama follows the journey...",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "70"
            )
        )
    }

    fun getMovieById(id: Int): Movie? {
        for (movie in generateMovies())
            if (id == movie.id) return movie
        return null
    }

    fun getTvshowById(id: Int): Tvshow? {
        for (tv in generateDummyTvShow())
            if (id == tv.id) return tv
        return null
    }

}