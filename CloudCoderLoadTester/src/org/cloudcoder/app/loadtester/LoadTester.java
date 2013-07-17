package org.cloudcoder.app.loadtester;

public class LoadTester {
	public static void main(String[] args) {
		HostConfig hostConfig = HostConfigDatabase.forName("default");
		
		Mix mix = MixDatabase.forName("default");
		
		/*
		Client client = new Client(hostConfig);
		if (!client.login("user2", "user2")) {
			throw new IllegalStateException("Could not login");
		}
		
		EditSequence editSequence = mix.get(0);
		System.out.println("Playing edit sequence for exercise " + editSequence.getExerciseName());

		PlayEditSequence player = new PlayEditSequence();
		player.setClient(client);
		player.setEditSequence(editSequence);
		player.setSubmitOnFullTextChange(true);
		player.setOnSend(new ICallback<Change[]>() {
			@Override
			public void call(Change[] value) {
				if (value.length == 1 && value[0].getType() == ChangeType.FULL_TEXT) {
					System.out.println("Sending full text for submission");
				} else {
					System.out.println("Sending " + value.length + " changes");
				}
			}
		});
		player.setOnSubmissionResult(new ICallback<SubmissionResult>() {
			public void call(SubmissionResult value) {
				if (value.getCompilationResult().getOutcome() != CompilationOutcome.SUCCESS) {
					System.out.println("Code did not compile");
				} else {
					System.out.println("Passed " + value.getNumTestsPassed() + "/" + value.getNumTestsAttempted() + " tests");
				}
			}
		});
		
		player.setup();
		player.play();
		*/
		
		LoadTesterTask task = new LoadTesterTask();
		task.setHostConfig(hostConfig);
		task.setEditSequence(mix.get(0));
		task.setUserName("user1");
		task.setPassword("user1");
		task.setRepeatCount(10);
		task.run();
		
		System.out.println("Done!");
	}
}