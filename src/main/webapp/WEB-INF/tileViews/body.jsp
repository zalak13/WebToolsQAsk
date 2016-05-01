
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<div class="tab-content">
	<div id="topQuestions" class="alert alert-success" role="alert"
		style="">
		<div class="container">
			<form style="display: inline" action="postAnswer.htm" method="POST">
				<h3>Top topics Questions</h3>
				<div class="panel panel-default">
					<div class="panel-heading">
						Topics:
						<div class="row" id="Topics"></div>
					</div>
					<div class="panel-body">
						<div class="row">
							Question ID:
							<ul id ="questionId"></ul>
						</div>
						<div class="row" >
							Title:
							<ul id="questionTitle"></ul>
						</div>
						<div class="row" >
							Question:
							<ul id="questionDesc"></ul>
						</div>
						<div class="row" >
							Posted By:
							<ul id="postedBy"></ul>
						</div>
						<div class="row" id="AnswerList">
							Answer List:
							<ul></ul>
						</div>
					</div>
					<div class="panel-buttons">
						<p>
						<li><a class="btn btn-success btn-xs btn-line" href="#">UpVote</a></li>
						<li><a class="btn btn-success btn-xs btn-line" href="#">DownVote</a></li>
						<li><a class="btn btn-success btn-xs btn-line"
							data-toggle="collapse" data-target="#messageArea" href="#">Comment</a></li>
						<!-- <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Simple collapsible</button> -->
						<div id="messageArea" class="collapse">
						<label> Message<span class="req">*</span>
				</label> <input type="textarea" name="message" required autocomplete="off" /><br />
				<br />
							<input type="submit" value = "Post" class ="commentBtn" ></button>
			 </form>
		</div>
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
	<form action="postQuestion.htm" method="POST">
		<div class="panel panel-default">
			<div class="panel-heading">
				Topics:
				<p id="Topics"></p>
			</div>
			<div class="panel-body">
				<label> Question Title<span class="req">*</span>
				</label> <input type="text" name="title" required autocomplete="off" /><br />
				<br /> <label> Message<span class="req">*</span>
				</label> <input type="textarea" name="message" required autocomplete="off" /><br />
				<br />

				<div class="col-lg-4">
					<label for="topicsID">Topics</label><span class="req">*</span> <select
						multiple name="topics" id="topicsID">
						<option value="Java">Java</option>
						<option value="C++">C++</option>
						<option value="Web technology">Web technology</option>
					</select>
				</div>
				<p>
					<button type="submit" class="btn btn-success btn-lg btn-line">Submit</button>
					</a>
				</p>

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