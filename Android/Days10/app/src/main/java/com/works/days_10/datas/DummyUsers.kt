package com.works.days_10.datas

import com.google.gson.Gson
import com.works.days_10.models.Users


object DummyUsers {

    fun getUsers() : Users {
        val gson = Gson()
        val data = gson.fromJson(stringUsers, Users::class.java)
        return data
    }

    private val stringUsers = "{\n" +
            "\"posts\": [\n" +
            "{\n" +
            "\"id\": 1,\n" +
            "\"title\": \"His mother had always taught him\",\n" +
            "\"body\": \"His mother had always taught him not to ever think of himself as better than others. He'd tried to live by this motto. He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.\",\n" +
            "\"userId\": 9,\n" +
            "\"tags\": [\n" +
            "\"history\",\n" +
            "\"american\",\n" +
            "\"crime\"\n" +
            "],\n" +
            "\"reactions\": 2\n" +
            "},\n" +
            "{\n" +
            "\"id\": 2,\n" +
            "\"title\": \"He was an expert but not in a discipline\",\n" +
            "\"body\": \"He was an expert but not in a discipline that anyone could fully appreciate. He knew how to hold the cone just right so that the soft server ice-cream fell into it at the precise angle to form a perfect cone each and every time. It had taken years to perfect and he could now do it without even putting any thought behind it.\",\n" +
            "\"userId\": 13,\n" +
            "\"tags\": [\n" +
            "\"french\",\n" +
            "\"fiction\",\n" +
            "\"english\"\n" +
            "],\n" +
            "\"reactions\": 2\n" +
            "},\n" +
            "{\n" +
            "\"id\": 3,\n" +
            "\"title\": \"Dave watched as the forest burned up on the hill.\",\n" +
            "\"body\": \"Dave watched as the forest burned up on the hill, only a few miles from her house. The car had been hastily packed and Marta was inside trying to round up the last of the pets. Dave went through his mental list of the most important papers and documents that they couldn't leave behind. He scolded himself for not having prepared these better in advance and hoped that he had remembered everything that was needed. He continued to wait for Marta to appear with the pets, but she still was nowhere to be seen.\",\n" +
            "\"userId\": 32,\n" +
            "\"tags\": [\n" +
            "\"magical\",\n" +
            "\"history\",\n" +
            "\"french\"\n" +
            "],\n" +
            "\"reactions\": 5\n" +
            "},\n" +
            "{\n" +
            "\"id\": 4,\n" +
            "\"title\": \"All he wanted was a candy bar.\",\n" +
            "\"body\": \"All he wanted was a candy bar. It didn't seem like a difficult request to comprehend, but the clerk remained frozen and didn't seem to want to honor the request. It might have had something to do with the gun pointed at his face.\",\n" +
            "\"userId\": 12,\n" +
            "\"tags\": [\n" +
            "\"mystery\",\n" +
            "\"english\",\n" +
            "\"american\"\n" +
            "],\n" +
            "\"reactions\": 1\n" +
            "},\n" +
            "{\n" +
            "\"id\": 5,\n" +
            "\"title\": \"Hopes and dreams were dashed that day.\",\n" +
            "\"body\": \"Hopes and dreams were dashed that day. It should have been expected, but it still came as a shock. The warning signs had been ignored in favor of the possibility, however remote, that it could actually happen. That possibility had grown from hope to an undeniable belief it must be destiny. That was until it wasn't and the hopes and dreams came crashing down.\",\n" +
            "\"userId\": 41,\n" +
            "\"tags\": [\n" +
            "\"crime\",\n" +
            "\"mystery\",\n" +
            "\"love\"\n" +
            "],\n" +
            "\"reactions\": 2\n" +
            "},\n" +
            "{\n" +
            "\"id\": 6,\n" +
            "\"title\": \"Dave wasn't exactly sure how he had ended up\",\n" +
            "\"body\": \"Dave wasn't exactly sure how he had ended up in this predicament. He ran through all the events that had lead to this current situation and it still didn't make sense. He wanted to spend some time to try and make sense of it all, but he had higher priorities at the moment. The first was how to get out of his current situation of being naked in a tree with snow falling all around and no way for him to get down.\",\n" +
            "\"userId\": 47,\n" +
            "\"tags\": [\n" +
            "\"english\",\n" +
            "\"classic\",\n" +
            "\"american\"\n" +
            "],\n" +
            "\"reactions\": 3\n" +
            "},\n" +
            "{\n" +
            "\"id\": 7,\n" +
            "\"title\": \"This is important to remember.\",\n" +
            "\"body\": \"This is important to remember. Love isn't like pie. You don't need to divide it among all your friends and loved ones. No matter how much love you give, you can always give more. It doesn't run out, so don't try to hold back giving it as if it may one day run out. Give it freely and as much as you want.\",\n" +
            "\"userId\": 12,\n" +
            "\"tags\": [\n" +
            "\"magical\",\n" +
            "\"crime\"\n" +
            "],\n" +
            "\"reactions\": 0\n" +
            "},\n" +
            "{\n" +
            "\"id\": 8,\n" +
            "\"title\": \"One can cook on and with an open fire.\",\n" +
            "\"body\": \"One can cook on and with an open fire. These are some of the ways to cook with fire outside. Cooking meat using a spit is a great way to evenly cook meat. In order to keep meat from burning, it's best to slowly rotate it.\",\n" +
            "\"userId\": 31,\n" +
            "\"tags\": [\n" +
            "\"american\",\n" +
            "\"english\"\n" +
            "],\n" +
            "\"reactions\": 9\n" +
            "},\n" +
            "{\n" +
            "\"id\": 9,\n" +
            "\"title\": \"There are different types of secrets.\",\n" +
            "\"body\": \"There are different types of secrets. She had held onto plenty of them during her life, but this one was different. She found herself holding onto the worst type. It was the type of secret that could gnaw away at your insides if you didn't tell someone about it, but it could end up getting you killed if you did.\",\n" +
            "\"userId\": 42,\n" +
            "\"tags\": [\n" +
            "\"american\",\n" +
            "\"history\",\n" +
            "\"magical\"\n" +
            "],\n" +
            "\"reactions\": 2\n" +
            "},\n" +
            "{\n" +
            "\"id\": 10,\n" +
            "\"title\": \"They rushed out the door.\",\n" +
            "\"body\": \"They rushed out the door, grabbing anything and everything they could think of they might need. There was no time to double-check to make sure they weren't leaving something important behind. Everything was thrown into the car and they sped off. Thirty minutes later they were safe and that was when it dawned on them that they had forgotten the most important thing of all.\",\n" +
            "\"userId\": 1,\n" +
            "\"tags\": [\n" +
            "\"fiction\",\n" +
            "\"magical\",\n" +
            "\"history\"\n" +
            "],\n" +
            "\"reactions\": 4\n" +
            "},\n" +
            "{\n" +
            "\"id\": 11,\n" +
            "\"title\": \"It wasn't quite yet time to panic.\",\n" +
            "\"body\": \"It wasn't quite yet time to panic. There was still time to salvage the situation. At least that is what she was telling himself. The reality was that it was time to panic and there wasn't time to salvage the situation, but he continued to delude himself into believing there was.\",\n" +
            "\"userId\": 25,\n" +
            "\"tags\": [\n" +
            "\"mystery\",\n" +
            "\"american\",\n" +
            "\"history\"\n" +
            "],\n" +
            "\"reactions\": 5\n" +
            "},\n" +
            "{\n" +
            "\"id\": 12,\n" +
            "\"title\": \"She was aware that things could go wrong.\",\n" +
            "\"body\": \"She was aware that things could go wrong. In fact, she had trained her entire life in anticipation that things would go wrong one day. She had quiet confidence as she started to see that this was the day that all her training would be worthwhile and useful. At this point, she had no idea just how wrong everything would go that day.\",\n" +
            "\"userId\": 26,\n" +
            "\"tags\": [\n" +
            "\"love\",\n" +
            "\"english\"\n" +
            "],\n" +
            "\"reactions\": 7\n" +
            "},\n" +
            "{\n" +
            "\"id\": 13,\n" +
            "\"title\": \"She wanted rainbow hair.\",\n" +
            "\"body\": \"She wanted rainbow hair. That's what she told the hairdresser. It should be deep rainbow colors, too. She wasn't interested in pastel rainbow hair. She wanted it deep and vibrant so there was no doubt that she had done this on purpose.\",\n" +
            "\"userId\": 44,\n" +
            "\"tags\": [\n" +
            "\"mystery\",\n" +
            "\"classic\",\n" +
            "\"french\"\n" +
            "],\n" +
            "\"reactions\": 0\n" +
            "},\n" +
            "{\n" +
            "\"id\": 14,\n" +
            "\"title\": \"The paper was blank.\",\n" +
            "\"body\": \"The paper was blank. It shouldn't have been. There should have been writing on the paper, at least a paragraph if not more. The fact that the writing wasn't there was frustrating. Actually, it was even more than frustrating. It was downright distressing.\",\n" +
            "\"userId\": 1,\n" +
            "\"tags\": [\n" +
            "\"mystery\",\n" +
            "\"english\",\n" +
            "\"love\"\n" +
            "],\n" +
            "\"reactions\": 0\n" +
            "},\n" +
            "{\n" +
            "\"id\": 15,\n" +
            "\"title\": \"The trees, therefore, must be such old\",\n" +
            "\"body\": \"The trees, therefore, must be such old and primitive techniques that they thought nothing of them, deeming them so inconsequential that even savages like us would know of them and not be suspicious. At that, they probably didn't have too much time after they detected us orbiting and intending to land. And if that were true, there could be only one place where their civilization was hidden.\",\n" +
            "\"userId\": 15,\n" +
            "\"tags\": [\n" +
            "\"fiction\",\n" +
            "\"history\",\n" +
            "\"crime\"\n" +
            "],\n" +
            "\"reactions\": 1\n" +
            "},\n" +
            "{\n" +
            "\"id\": 16,\n" +
            "\"title\": \"There was only one way to do things in the Statton house.\",\n" +
            "\"body\": \"There was only one way to do things in the Statton house. That one way was to do exactly what the father, Charlie, demanded. He made the decisions and everyone else followed without question. That was until today.\",\n" +
            "\"userId\": 31,\n" +
            "\"tags\": [\n" +
            "\"magical\",\n" +
            "\"french\",\n" +
            "\"american\"\n" +
            "],\n" +
            "\"reactions\": 5\n" +
            "},\n" +
            "{\n" +
            "\"id\": 17,\n" +
            "\"title\": \"She was in a hurry.\",\n" +
            "\"body\": \"She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead.\",\n" +
            "\"userId\": 5,\n" +
            "\"tags\": [\n" +
            "\"french\",\n" +
            "\"magical\",\n" +
            "\"english\"\n" +
            "],\n" +
            "\"reactions\": 0\n" +
            "},\n" +
            "{\n" +
            "\"id\": 18,\n" +
            "\"title\": \"She had a terrible habit o comparing her life to others\",\n" +
            "\"body\": \"She had a terrible habit o comparing her life to others. She realized that their life experiences were completely different than her own and that she saw only what they wanted her to see, but that didn't matter. She still compared herself and yearned for what she thought they had and she didn't.\",\n" +
            "\"userId\": 28,\n" +
            "\"tags\": [\n" +
            "\"history\",\n" +
            "\"french\",\n" +
            "\"love\"\n" +
            "],\n" +
            "\"reactions\": 3\n" +
            "},\n" +
            "{\n" +
            "\"id\": 19,\n" +
            "\"title\": \"The rain and wind abruptly stopped.\",\n" +
            "\"body\": \"The rain and wind abruptly stopped, but the sky still had the gray swirls of storms in the distance. Dave knew this feeling all too well. The calm before the storm. He only had a limited amount of time before all Hell broke loose, but he stopped to admire the calmness. Maybe it would be different this time, he thought, with the knowledge deep within that it wouldn't.\",\n" +
            "\"userId\": 46,\n" +
            "\"tags\": [\n" +
            "\"fiction\",\n" +
            "\"crime\",\n" +
            "\"magical\"\n" +
            "],\n" +
            "\"reactions\": 8\n" +
            "},\n" +
            "{\n" +
            "\"id\": 20,\n" +
            "\"title\": \"He couldn't remember exactly where he had read it\",\n" +
            "\"body\": \"He couldn't remember exactly where he had read it, but he was sure that he had. The fact that she didn't believe him was quite frustrating as he began to search the Internet to find the article. It wasn't as if it was something that seemed impossible. Yet she insisted on always seeing the source whenever he stated a fact.\",\n" +
            "\"userId\": 38,\n" +
            "\"tags\": [\n" +
            "\"french\",\n" +
            "\"classic\"\n" +
            "],\n" +
            "\"reactions\": 9\n" +
            "},\n" +
            "{\n" +
            "\"id\": 21,\n" +
            "\"title\": \"He wandered down the stairs and into the basement\",\n" +
            "\"body\": \"He wandered down the stairs and into the basement. The damp, musty smell of unuse hung in the air. A single, small window let in a glimmer of light, but this simply made the shadows in the basement deeper. He inhaled deeply and looked around at a mess that had been accumulating for over 25 years. He was positive that this was the place he wanted to live.\",\n" +
            "\"userId\": 37,\n" +
            "\"tags\": [\n" +
            "\"french\",\n" +
            "\"american\"\n" +
            "],\n" +
            "\"reactions\": 8\n" +
            "},\n" +
            "{\n" +
            "\"id\": 22,\n" +
            "\"title\": \"She has seen this scene before.\",\n" +
            "\"body\": \"She has seen this scene before. It had come to her in dreams many times before. She had to pinch herself to make sure it wasn't a dream again. As her fingers squeezed against her arm, she felt the pain. It was this pain that immediately woke her up.\",\n" +
            "\"userId\": 30,\n" +
            "\"tags\": [\n" +
            "\"classic\",\n" +
            "\"love\",\n" +
            "\"history\"\n" +
            "],\n" +
            "\"reactions\": 6\n" +
            "},\n" +
            "{\n" +
            "\"id\": 23,\n" +
            "\"title\": \"It's an unfortunate reality that we don't teach people how to make money\",\n" +
            "\"body\": \"It's an unfortunate reality that we don't teach people how to make money (beyond getting a 9 to 5 job) as part of our education system. The truth is there are a lot of different, legitimate ways to make money. That doesn't mean they are easy and that you won't have to work hard to succeed, but it does mean that if you're willing to open your mind a bit you don't have to be stuck in an office from 9 to 5 for the next fifty years o your life.\",\n" +
            "\"userId\": 2,\n" +
            "\"tags\": [\n" +
            "\"crime\",\n" +
            "\"english\"\n" +
            "],\n" +
            "\"reactions\": 4\n" +
            "},\n" +
            "{\n" +
            "\"id\": 24,\n" +
            "\"title\": \"The robot clicked disapprovingly.\",\n" +
            "\"body\": \"The robot clicked disapprovingly, gurgled briefly inside its cubical interior and extruded a pony glass of brownish liquid. \\\"Sir, you will undoubtedly end up in a drunkard's grave, dead of hepatic cirrhosis,\\\" it informed me virtuously as it returned my ID card. I glared as I pushed the glass across the table.\",\n" +
            "\"userId\": 34,\n" +
            "\"tags\": [\n" +
            "\"crime\",\n" +
            "\"american\",\n" +
            "\"love\"\n" +
            "],\n" +
            "\"reactions\": 2\n" +
            "},\n" +
            "{\n" +
            "\"id\": 25,\n" +
            "\"title\": \"It went through such rapid contortions\",\n" +
            "\"body\": \"It went through such rapid contortions that the little bear was forced to change his hold on it so many times he became confused in the darkness, and could not, for the life of him, tell whether he held the sheep right side up, or upside down. But that point was decided for him a moment later by the animal itself, who, with a sudden twist, jabbed its horns so hard into his lowest ribs that he gave a grunt of anger and disgust.\",\n" +
            "\"userId\": 27,\n" +
            "\"tags\": [\n" +
            "\"fiction\",\n" +
            "\"history\",\n" +
            "\"french\"\n" +
            "],\n" +
            "\"reactions\": 3\n" +
            "},\n" +
            "{\n" +
            "\"id\": 26,\n" +
            "\"title\": \"She patiently waited for his number to be called.\",\n" +
            "\"body\": \"She patiently waited for his number to be called. She had no desire to be there, but her mom had insisted that she go. She's resisted at first, but over time she realized it was simply easier to appease her and go. Mom tended to be that way. She would keep insisting until you wore down and did what she wanted. So, here she sat, patiently waiting for her number to be called.\",\n" +
            "\"userId\": 27,\n" +
            "\"tags\": [\n" +
            "\"french\",\n" +
            "\"mystery\",\n" +
            "\"crime\"\n" +
            "],\n" +
            "\"reactions\": 7\n" +
            "},\n" +
            "{\n" +
            "\"id\": 27,\n" +
            "\"title\": \"Ten more steps.\",\n" +
            "\"body\": \"If he could take ten more steps it would be over, but his legs wouldn't move. He tried to will them to work, but they wouldn't listen to his brain. Ten more steps and it would be over but it didn't appear he would be able to do it.\",\n" +
            "\"userId\": 17,\n" +
            "\"tags\": [\n" +
            "\"mystery\",\n" +
            "\"classic\",\n" +
            "\"love\"\n" +
            "],\n" +
            "\"reactions\": 4\n" +
            "},\n" +
            "{\n" +
            "\"id\": 28,\n" +
            "\"title\": \"He had three simple rules by which he lived.\",\n" +
            "\"body\": \"He had three simple rules by which he lived. The first was to never eat blue food. There was nothing in nature that was edible that was blue. People often asked about blueberries, but everyone knows those are actually purple. He understood it was one of the stranger rules to live by, but it had served him well thus far in the 50+ years of his life.\",\n" +
            "\"userId\": 22,\n" +
            "\"tags\": [\n" +
            "\"crime\",\n" +
            "\"love\"\n" +
            "],\n" +
            "\"reactions\": 2\n" +
            "},\n" +
            "{\n" +
            "\"id\": 29,\n" +
            "\"title\": \"The chair sat in the corner where it had been\",\n" +
            "\"body\": \"The chair sat in the corner where it had been for over 25 years. The only difference was there was someone actually sitting in it. How long had it been since someone had done that? Ten years or more he imagined. Yet there was no denying the presence in the chair now.\",\n" +
            "\"userId\": 38,\n" +
            "\"tags\": [\n" +
            "\"mystery\",\n" +
            "\"american\"\n" +
            "],\n" +
            "\"reactions\": 6\n" +
            "},\n" +
            "{\n" +
            "\"id\": 30,\n" +
            "\"title\": \"Things aren't going well at all\",\n" +
            "\"body\": \"Things aren't going well at all with mom today. She is just a limp noodle and wants to sleep all the time. I sure hope that things get better soon.\",\n" +
            "\"userId\": 2,\n" +
            "\"tags\": [\n" +
            "\"american\",\n" +
            "\"love\",\n" +
            "\"fiction\"\n" +
            "],\n" +
            "\"reactions\": 0\n" +
            "}\n" +
            "],\n" +
            "\"total\": 150,\n" +
            "\"skip\": 0,\n" +
            "\"limit\": 30\n" +
            "}"

}