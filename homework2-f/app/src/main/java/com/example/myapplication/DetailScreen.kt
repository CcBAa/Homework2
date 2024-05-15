package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    index: Int,
    name: String,
    navController: NavController,
    navigateUp: () -> Unit
){
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "Detail Screen") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_revert),
                        contentDescription = "Back to Start Screen"
                    )
                }
            }
        )
        val image = painterResource(spotpic(index+1))
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = spotdetail(index+1),
            fontSize = 16.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        ElevatedButton(
            onClick = {
                val url = "https://www.google.com/maps/search/?api=1&query=${Uri.encode(" $name")}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }
        ) {
            Text(
                "Google Map",
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun spotdetail(index: Int): String{
    return when (index) {
        1 -> "台北101（英語：TAIPEI 101）是位於臺灣臺北市信義計畫區的超高層摩天大樓，樓高508公尺，地上101層、地下5層。於2004年12月31日落成至2010年1月4日是世界第一高樓。目前是台灣第一高樓，以及臺灣唯一高度超過500公尺、樓層超過100層的建築物。台北101由建築師李祖原設計，採用了後現代主義建築風格，並在採用工業材料等現代結構的同時喚起傳統的亞洲美學。其建築物的設計結合了許多特點，使該結構能夠抵禦環太平洋火山帶的地震和影響臺灣的熱帶氣旋氣候。塔樓則設有辦公室、餐廳、商店、觀景台及戶外觀景步道提供民眾使用，並擁有全球次重、全球唯二開放給遊客觀賞的巨型阻尼器為其特色，塔樓旁則設有一座多層購物中心，該購物中心擁有世界上最大的如意符號作為外部元素。此外該建築也配屬超高速電梯設施，能夠以60公里/小時的速度運行。"
        2 -> "國立故宮博物院，簡稱臺灣故宮或臺北故宮，別名中山博物院，為臺灣最具規模的博物館以及臺灣八景之一，也是古代中國藝術史與漢學研究機構。館舍分別位於臺北市士林區與嘉義縣太保市，一年接待超過614萬人次的參訪旅客，曾位列2015年全球參觀人數第六多的藝術博物館。在國立故宮博物院典藏為數近70萬件文物與藝術作品，大部分是原先國立北平故宮博物院、國立中央博物院籌備處和國立北平圖書館等機構所藏來自紫禁城、盛京行宮、避暑山莊、頤和園、靜宜園和國子監等處皇家舊藏另有部分是編列預算購置，接收自第二次世界大戰結束日本歸還部分文物，以及透過各界捐贈和徵集而來。藏品時間跨度涵蓋新石器時代至今長達8,000年，各類藏品分別交由器物處、書畫文獻處和南院處等3個策展部門管理，當中以長篇銘文的青銅器、古代早期的名家書畫、善本古籍和官窯瓷器等蒐藏最具影響力。"
        3 -> "中正紀念堂是位於中華民國臺北市中正區的國家紀念建築，是中華民國政府為紀念已故前總統蔣中正而興建，為眾多紀念蔣中正的建築中規模最大者，管理機關為中華民國文化部轄下的「國立中正紀念堂管理處」。全區250,000平方公尺，紀念堂主堂體高70公尺；園區廣場前方兩廳院稱為「藝文廣場」，廣場南北側另建有國家戲劇院以及國家音樂廳，合稱「國家兩廳院」，由國家表演藝術中心管理。廣場除了供民眾休憩外，也是大型藝文活動的場地，常舉辦展覽及表演；邦交國元首訪臺歡迎儀式（軍禮）也在此舉行。園區主體建築、大道、廣場及牌樓等以「臺灣民主紀念園區」之名義，由行政院文化建設委員會（今文化部）指定為國定古蹟（與臺灣民主紀念館更名事件有關）；東門、中山南路部分路段及園區以「中正紀念堂」之名義由臺北市政府登錄為文化景觀。"
        4 -> "象山海拔183公尺，步道全長1450公尺，全程約需1小時40分。因外形似象頭而得名，位於臺北盆地東南方的信義區，與虎山地質相同主要由砂岩組成，因造山作用步道中可見黃褐色陡峭的岩壁與巨石，加上自然環境生物、鳥類種類繁多，使得整座山如同一座天然生態樂園般，成為民眾接近淺山、享受戶外綠林悠閒時光的好去處。象山擁有稜線、岩壁、山坡、山窪、山谷等各種不同微環境，因而孕育出數十種蕨類。蕨類在象山處處可見，有的附著在樹幹上，有的長在岩石、坡地上，有的密佈在潮濕的林下。其中金狗毛蕨族群龐大，數量居臺北市之冠，在過去醫藥不發達的年代，它可是民間用來止血的最佳良藥。另外在開闊、向陽且潮濕山窪區，還有自侏儸紀時期就存在的古老蕨類「筆筒樹」。筆筒樹群聚可是臺北市區最珍貴的生態特色，因為筆筒樹成群林立的現象，全世界只有臺灣北部才能看得到。"
        5 -> "太魯閣國家公園座落於花蓮、臺中及南投三縣市。其範圍以立霧溪峽谷、東西橫貫公路沿線及其外圍山區為主，包括合歡群峰、奇萊連峰、南湖中央尖山連峰、清水斷崖、立霧溪流域及三棧溪流域等，全部面積共計九萬二千公頃。太魯閣國家公園境內地勢高聳，大致由西部的脊樑山脈向東傾斜，其間山巒起伏，二千公尺以上的山區面積約佔全境之半，其中有將近六分之一的面積為三千公尺以上的高峰所據。這些高山氣勢雄偉，當中躋身「臺灣百岳」者即達二十七座之多。境內河川以脊樑山脈為主要的分水嶺向東西奔流。東側是立霧溪流域，面積約佔整個國家公園的三分之二，主流貫穿公園中部，支流則由西方及北方來會；脊樑山脈西側狹長的區域是大甲溪上游的南湖溪、耳無溪、畢綠溪等等。太魯閣國家公園涵蓋了劇烈造山運動隆起形成的變質岩區，區內岩層走向大致成東北往西南向，園內高山突兀，峽谷深邃，奇景美不勝收，極具特色之處。"
        6 -> "貓空纜車為臺北市第一條纜車系統，係採用法國POMA公司所生產的自動循環式系統，最短發車間隔為12秒，全程搭乘時間約為20分鐘。每節車廂可容納8人，單向最高載客量約為每小時2,000人。車廂有144部，另有3部備用車廂。全長達4.03公里，行駛路線成7字型，共有4個停靠站，依序為「動物園站」、「動物園南站」、「指南宮站」及「貓空站」。另外還有2個不停靠的轉角站，主要目的為引導鋼纜進行轉彎，幾近90度的大轉彎，也是貓空纜車一大特色。在纜車上能從高空俯瞰貓空茶園的景色，隨著纜車上山，也別有一番刺激感。"
        7 -> "艋舺龍山寺，也稱萬華龍山寺，是位於臺灣臺北市萬華區（艋舺）的觀音寺，為龍山寺之一。建築列為國定古蹟。創建於清乾隆三年（1738）艋舺龍山寺，除了是臺北地區泉州三邑人的信仰中心外，也見證了艋舺行郊的發展過程。 作為艋舺信仰中心，艋舺龍山寺的祭祀儀典與組織及影響範圍，不僅在萬華地區的祭祀圈而已，更推展到北臺灣其他地區的泉州三邑移民，具有跨區域的信仰特質。"
        8 -> "臺北市立動物園是中華民國臺灣臺北市的一座公立動物園，隸屬於臺北市政府教育局。1914年創立於圓山地區，舊稱「圓山動物園」，與臺北市立兒童育樂中心（臺北市立兒童新樂園舊址，今圓山遺址）相鄰。1986年，因圓山原址無法擴建，而遷至木柵區（今文山區），因此成為臺灣民眾現在所熟悉的「木柵動物園」。遷至木柵後，園區總面積原為182公頃，隨後因捷運動物園站及北二高的開闢，移撥出部分土地，目前仍有165公頃之廣，其中已開發使用區域近百公頃，是全臺佔地面積最大的動物園。園內包含8個戶外展示區、6個室內展示館、2個環境教育教學場所，2021年底有動物354種、2,407隻（未計算昆蟲、部分魚類及農委會收容計畫動物）。整個園區被自然次生林地所圍繞，是一處結合自然景觀形成具生態特色之休閒場所。"
        9 -> "日月潭，是一個位在臺灣南投縣魚池鄉日月村的半天然淡水湖泊兼水力發電用水庫；該潭是臺灣本島面積第二大的湖泊（僅次於曾文水庫）及第一大半天然湖泊兼發電用水庫。該潭平均水面海拔約736公尺，常態面積約7.93平方公里（滿水位時約8.4平方公里），最高水深達27公尺。其蘊含自然生態豐富，但其中有非常多是外來種生物。該潭是台灣平埔族的邵族所生活的主要地區之一，屬於邵族傳統領域；生活在該潭四周的族人稱其為「水社海」。由於過去當地附近平埔族稱居住於山裡的高山族，為「沙連」，當地又是山區最大的積水盆地，日月潭及其周圍地區因而得名「水沙連」。此外，尚有「水社大湖」、「龍湖」、「珠潭」、「雙潭」等名稱。其今名為日潭與月潭之合稱，該二名分別來自對其兩大組成部份水色及輪廓的描繪。同時，該潭景色自古以來經常受人讚賞，並自日本統治時期以來多次被有關當局列入臺灣八景。[5]"
        10 -> "九份老街是位於臺灣新北市瑞芳區的一條老街，主要範圍以聚集在基山街、豎崎路及輕便路等街道為主，是全台灣最熱門的觀光景點之一，全年觀光客絡繹不絕。若以客源分析，平日以來自日本、韓國等地的外籍觀光客以及中國大陸、香港、澳門的遊客和本國遊客各占一半，假日則以國民旅遊為主，是北台灣國際級的觀光景點。商圈定位鮮明，集歷史、天然景致、美食文化於一爐。建議去走走的好地方。人文歷史景觀如台陽礦業事務所、彭園、五番坑口 、昇平戲院等，而位於九份上，往下可俯視基隆嶼、八斗子、番仔澳、鼻頭角等地的海景，往上可眺望雞籠山景。九份日夜氛圍不同，於白日可俯瞰海景，感受九份老街旺盛人氣，於夜晚一切歸於寧靜，靜靜坐在茶樓間，細品九份寧靜氛圍，往外看，僅剩盞盞漁火於海面上。"
        else -> " "
    }
}

@Composable
fun spotpic(index: Int): Int {
    return when (index) {
        1 -> R.drawable.image1
        2 -> R.drawable.image2
        3 -> R.drawable.image3
        4 -> R.drawable.image4
        5 -> R.drawable.image5
        6 -> R.drawable.image6
        7 -> R.drawable.image7
        8 -> R.drawable.image8
        9 -> R.drawable.image9
        10 -> R.drawable.image10
        else -> R.drawable.imageerror
    }
}