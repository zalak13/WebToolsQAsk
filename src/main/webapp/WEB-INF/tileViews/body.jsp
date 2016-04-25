<div class="tab-content">
	<div id="topQuestions" class="alert alert-success" role="alert"
		style="">
		<div class="container">
			<h3>Top topics Questions</h3>
			<div class="panel panel-default">
				<div class="panel-heading">
					Topics:
					<p id="Topics"></p>
				</div>
				<div class="panel-body">
					Question<ul id="questionDesc"></ul>
					Posted By<ul id="postedBy"></ul>
					Answer List<ul id="AnswerList"></ul>
				</div>
				<div class="panel-buttons">
					<p>
					<li><a class="btn btn-success btn-xs btn-line" href="#">UpVote</a></li>
					<li><a class="btn btn-success btn-xs btn-line" href="#">DownVote</a></li>
					<li><a class="btn btn-success btn-xs btn-line" href="#">Comment</a></li>
					</p>
				</div>
				<div class="panel-footer">
					<br />
					<h6>
						&#169; 2016 Copyright by QAsk
						<h6>
				</div>
			</div>
		</div>
	</div>
	<div id="postQuestion">
		<h3>Post a Question</h3>
		<form action="postQuestion.htm" method = "POST">
		<div class="panel panel-default">
			<div class="panel-heading">
				Topics:
				<p id="Topics"></p>
			</div>
			<div class="panel-body">
				<label> Question Title<span class="req">*</span>
				</label> <input type="text" name="title" required autocomplete="off" /><br />
				<br /> <label> Message<span class="req">*</span>
				</label> <input type="text"  name="message" required autocomplete="off" /><br/><br/>

				<div class="col-lg-4">
					<label for="topicsID">Topics</label><span class="req">*</span>
					<select multiple name="topics" id="topicsID">
						<option value="Java">Java</option>
						<option value="C++">C++</option>
						<option value="Web technology">Web technology</option>
					</select>
				</div>
				<p><button type="submit" class="btn btn-success btn-lg btn-line">Submit</button></a></p>

			</div>
			<div class="panel-buttons">
				<p>
				<li><a class="btn btn-success btn-xs btn-line" href="#">Comment</a></li>
				</p>
			</div>
			<div class="panel-footer">
				<br />
				<h6>
					&#169; 2016 Copyright by QAsk
					<h6>
			</div>
		</div>
		</form>
	</div>

</div>