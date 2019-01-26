package models;

public class ViewTestData {

	public String[] getTopics() {
		String[] topics = new String[]
				{
						"今日の天気",
						"注目のニュース",
						"イベント",
						"道路交通情報",
						"おすすめグルメ"
				};
		return topics;
	}

	public String getTopic(Integer index) {
		String[] topics = getTopics();
		// 最小、最大チェック。NGはindex:0を返す。
		if(index < 0 || topics.length <= index) {
			return topics[0];
		}
		return topics[index];
	}

}
