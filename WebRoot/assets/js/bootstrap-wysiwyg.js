




<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>bootstrap-wysiwyg/bootstrap-wysiwyg.js at master · mindmup/bootstrap-wysiwyg · GitHub</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <meta property="fb:app_id" content="1401488693436528"/>

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="mindmup/bootstrap-wysiwyg" name="twitter:title" /><meta content="bootstrap-wysiwyg - Tiny bootstrap-compatible WISWYG rich text editor" name="twitter:description" /><meta content="https://2.gravatar.com/avatar/9935ac282707e06ec95a2bea772c368e?d=https%3A%2F%2Fidenticons.github.com%2Ffe845f902225683e5718c0a62f75057f.png&amp;r=x&amp;s=400" name="twitter:image:src" />
<meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://2.gravatar.com/avatar/9935ac282707e06ec95a2bea772c368e?d=https%3A%2F%2Fidenticons.github.com%2Ffe845f902225683e5718c0a62f75057f.png&amp;r=x&amp;s=400" property="og:image" /><meta content="mindmup/bootstrap-wysiwyg" property="og:title" /><meta content="https://github.com/mindmup/bootstrap-wysiwyg" property="og:url" /><meta content="bootstrap-wysiwyg - Tiny bootstrap-compatible WISWYG rich text editor" property="og:description" />

    <meta name="hostname" content="github-fe128-cp1-prd.iad.github.net">
    <meta name="ruby" content="ruby 2.1.0p0-github-tcmalloc (87c9373a41) [x86_64-linux]">
    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035/">
    <link rel="xhr-socket" href="/_sockets" />


    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="collector-cdn.github.com" name="octolytics-script-host" /><meta content="github" name="octolytics-app-id" /><meta content="7B712D36:1E8C:3FB54CD:531C11D5" name="octolytics-dimension-request_id" />
    

    
    
    <link rel="icon" type="image/x-icon" href="/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="jA2grMuRX3eI7xJQy9vTMaq+B7QOjE5aSosmkAFt35A=" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-d648f1196659f589579aa6aaddcc78c4f8e87552.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-32987ede34015d8eaa4618614894d836adf201f6.css" media="all" rel="stylesheet" type="text/css" />
    
    


      <script crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/frameworks-855d68c505f4b08a77e4d991f11cf5d8f43250e2.js" type="text/javascript"></script>
      <script async="async" crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/github-e6bd35a239a3a0ab82cd42cd9df317778e5a1270.js" type="text/javascript"></script>
      
      <meta http-equiv="x-pjax-version" content="2fe0694ce2393a8db660e33f758021ee">

        <link data-pjax-transient rel='permalink' href='/mindmup/bootstrap-wysiwyg/blob/9304f95917d603d813a9a9fd2670a586e5d74cde/bootstrap-wysiwyg.js'>

  <meta name="description" content="bootstrap-wysiwyg - Tiny bootstrap-compatible WISWYG rich text editor" />

  <meta content="3287699" name="octolytics-dimension-user_id" /><meta content="mindmup" name="octolytics-dimension-user_login" /><meta content="9226653" name="octolytics-dimension-repository_id" /><meta content="mindmup/bootstrap-wysiwyg" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="9226653" name="octolytics-dimension-repository_network_root_id" /><meta content="mindmup/bootstrap-wysiwyg" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/mindmup/bootstrap-wysiwyg/commits/master.atom" rel="alternate" title="Recent Commits to bootstrap-wysiwyg:master" type="application/atom+xml" />

  </head>


  <body class="logged_out  env-production windows vis-public page-blob tipsy-tooltips">
    <a href="#start-of-content" class="accessibility-aid js-skip-to-content">Skip to content</a>
    <div class="wrapper">
      
      
      
      


      
      <div class="header header-logged-out">
  <div class="container clearfix">

    <a class="header-logo-wordmark" href="https://github.com/">
      <span class="mega-octicon octicon-logo-github"></span>
    </a>

    <div class="header-actions">
        <a class="button primary" href="/join">Sign up</a>
      <a class="button signin" href="/login?return_to=%2Fmindmup%2Fbootstrap-wysiwyg%2Fblob%2Fmaster%2Fbootstrap-wysiwyg.js">Sign in</a>
    </div>

    <div class="command-bar js-command-bar  in-repository">

      <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
        <li class="features"><a href="/features">Features</a></li>
          <li class="enterprise"><a href="https://enterprise.github.com/">Enterprise</a></li>
          <li class="blog"><a href="/blog">Blog</a></li>
      </ul>
        <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    
      data-repo="mindmup/bootstrap-wysiwyg"
      data-branch="master"
      data-sha="4020fc56832745420f86770981d46cbff278b466"
  >

    <input type="hidden" name="nwo" value="mindmup/bootstrap-wysiwyg" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target" role="button" aria-haspopup="true">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container" aria-hidden="true">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="help tooltipped tooltipped-s" aria-label="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
    </div>

  </div>
</div>



      <div id="start-of-content" class="accessibility-aid"></div>
          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">


  <li>
    <a href="/login?return_to=%2Fmindmup%2Fbootstrap-wysiwyg"
    class="minibutton with-count js-toggler-target star-button tooltipped tooltipped-n"
    aria-label="You must be signed in to star a repository" rel="nofollow">
    <span class="octicon octicon-star"></span>Star
  </a>

    <a class="social-count js-social-count" href="/mindmup/bootstrap-wysiwyg/stargazers">
      3,545
    </a>

  </li>

    <li>
      <a href="/login?return_to=%2Fmindmup%2Fbootstrap-wysiwyg"
        class="minibutton with-count js-toggler-target fork-button tooltipped tooltipped-n"
        aria-label="You must be signed in to fork a repository" rel="nofollow">
        <span class="octicon octicon-git-branch"></span>Fork
      </a>
      <a href="/mindmup/bootstrap-wysiwyg/network" class="social-count">
        728
      </a>
    </li>
</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="repo-label"><span>public</span></span>
          <span class="mega-octicon octicon-repo"></span>
          <span class="author">
            <a href="/mindmup" class="url fn" itemprop="url" rel="author"><span itemprop="title">mindmup</span></a>
          </span>
          <span class="repohead-name-divider">/</span>
          <strong><a href="/mindmup/bootstrap-wysiwyg" class="js-current-repository js-repo-home-link">bootstrap-wysiwyg</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">
      <div class="repository-with-sidebar repo-container new-discussion-timeline js-new-discussion-timeline  ">
        <div class="repository-sidebar clearfix">
            

<div class="sunken-menu vertical-right repo-nav js-repo-nav js-repository-container-pjax js-octicon-loaders">
  <div class="sunken-menu-contents">
    <ul class="sunken-menu-group">
      <li class="tooltipped tooltipped-w" aria-label="Code">
        <a href="/mindmup/bootstrap-wysiwyg" aria-label="Code" class="selected js-selected-navigation-item sunken-menu-item" data-gotokey="c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /mindmup/bootstrap-wysiwyg">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped tooltipped-w" aria-label="Issues">
          <a href="/mindmup/bootstrap-wysiwyg/issues" aria-label="Issues" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-gotokey="i" data-selected-links="repo_issues /mindmup/bootstrap-wysiwyg/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>69</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped tooltipped-w" aria-label="Pull Requests">
        <a href="/mindmup/bootstrap-wysiwyg/pulls" aria-label="Pull Requests" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-gotokey="p" data-selected-links="repo_pulls /mindmup/bootstrap-wysiwyg/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>13</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


    </ul>
    <div class="sunken-menu-separator"></div>
    <ul class="sunken-menu-group">

      <li class="tooltipped tooltipped-w" aria-label="Pulse">
        <a href="/mindmup/bootstrap-wysiwyg/pulse" aria-label="Pulse" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="pulse /mindmup/bootstrap-wysiwyg/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Graphs">
        <a href="/mindmup/bootstrap-wysiwyg/graphs" aria-label="Graphs" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_graphs repo_contributors /mindmup/bootstrap-wysiwyg/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Network">
        <a href="/mindmup/bootstrap-wysiwyg/network" aria-label="Network" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-selected-links="repo_network /mindmup/bootstrap-wysiwyg/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


  </div>
</div>

              <div class="only-with-full-nav">
                

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=clone">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/mindmup/bootstrap-wysiwyg.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/mindmup/bootstrap-wysiwyg.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=clone">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/mindmup/bootstrap-wysiwyg" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/mindmup/bootstrap-wysiwyg" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <span class="help tooltipped tooltipped-n" aria-label="Get help on which URL is right for you.">
    <a href="https://help.github.com/articles/which-remote-url-should-i-use">
    <span class="octicon octicon-question"></span>
    </a>
  </span>
</p>


  <a href="http://windows.github.com" class="minibutton sidebar-button">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>

                <a href="/mindmup/bootstrap-wysiwyg/archive/master.zip"
                   class="minibutton sidebar-button"
                   title="Download this repository as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
              </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:e4fccefaa595a8ff8a6f772827d5b8f6 -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/mindmup/bootstrap-wysiwyg/find/master" data-pjax data-hotkey="t" class="js-show-file-finder" style="display:none">Show File Finder</a>

<div class="file-navigation">
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    role="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Filter branches/tags" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/mindmup/bootstrap-wysiwyg/blob/gh-pages/bootstrap-wysiwyg.js"
                 data-name="gh-pages"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="gh-pages">gh-pages</a>
            </div> <!-- /.select-menu-item -->
            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/mindmup/bootstrap-wysiwyg/blob/master/bootstrap-wysiwyg.js"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/mindmup/bootstrap-wysiwyg" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">bootstrap-wysiwyg</span></a></span></span><span class="separator"> / </span><strong class="final-path">bootstrap-wysiwyg.js</strong> <span aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="bootstrap-wysiwyg.js" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


  <div class="commit file-history-tease">
    <img alt="Gojko Adzic" class="main-avatar js-avatar" data-user="38767" height="24" src="https://0.gravatar.com/avatar/efb68f18ef5da3b9d25be331625f89f2?d=https%3A%2F%2Fidenticons.github.com%2F68c721845f6910d1d3c03cabfb172350.png&amp;r=x&amp;s=140" width="24" />
    <span class="author"><a href="/gojko" rel="author">gojko</a></span>
    <time class="js-relative-date" data-title-format="YYYY-MM-DD HH:mm:ss" datetime="2013-04-17T15:09:05-07:00" title="2013-04-17 15:09:05">April 17, 2013</time>
    <div class="commit-title">
        <a href="/mindmup/bootstrap-wysiwyg/commit/6f808e50efd3929d13068dca364ad9cdd1316952" class="message" data-pjax="true" title="Merge branch 'images' of https://github.com/jordandh/bootstrap-wysiwyg">Merge branch 'images' of</a> <a href="https://github.com/jordandh/bootstrap-wysiwyg">https://github.com/jordandh/bootstrap-wysiwyg</a>
    </div>

    <div class="participation">
      <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>4</strong> contributors</a></p>
          <a class="avatar tooltipped tooltipped-s" aria-label="gojko" href="/mindmup/bootstrap-wysiwyg/commits/master/bootstrap-wysiwyg.js?author=gojko"><img alt="Gojko Adzic" class=" js-avatar" data-user="38767" height="20" src="https://0.gravatar.com/avatar/efb68f18ef5da3b9d25be331625f89f2?d=https%3A%2F%2Fidenticons.github.com%2F68c721845f6910d1d3c03cabfb172350.png&amp;r=x&amp;s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="jordandh" href="/mindmup/bootstrap-wysiwyg/commits/master/bootstrap-wysiwyg.js?author=jordandh"><img alt="Jordan Harrison" class=" js-avatar" data-user="68006" height="20" src="https://1.gravatar.com/avatar/733d01811a593de74c1c75ad9a95ecb3?d=https%3A%2F%2Fidenticons.github.com%2F3231749a6d256f6b819ff0aef52ecd03.png&amp;r=x&amp;s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="dmethvin" href="/mindmup/bootstrap-wysiwyg/commits/master/bootstrap-wysiwyg.js?author=dmethvin"><img alt="Dave Methvin" class=" js-avatar" data-user="157858" height="20" src="https://0.gravatar.com/avatar/161a4cc619398bea1e1714036ed122cf?d=https%3A%2F%2Fidenticons.github.com%2F5408b5993e9003e9e3394257eff47f20.png&amp;r=x&amp;s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="davedf" href="/mindmup/bootstrap-wysiwyg/commits/master/bootstrap-wysiwyg.js?author=davedf"><img alt="davedf" class=" js-avatar" data-user="298180" height="20" src="https://0.gravatar.com/avatar/398ac8cccb86108f072869b7b2ec8a23?d=https%3A%2F%2Fidenticons.github.com%2F72e4af299f5728b0d0e39bbdba336c31.png&amp;r=x&amp;s=140" width="20" /></a>


    </div>
    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list">
          <li class="facebox-user-list-item">
            <img alt="Gojko Adzic" class=" js-avatar" data-user="38767" height="24" src="https://0.gravatar.com/avatar/efb68f18ef5da3b9d25be331625f89f2?d=https%3A%2F%2Fidenticons.github.com%2F68c721845f6910d1d3c03cabfb172350.png&amp;r=x&amp;s=140" width="24" />
            <a href="/gojko">gojko</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="Jordan Harrison" class=" js-avatar" data-user="68006" height="24" src="https://1.gravatar.com/avatar/733d01811a593de74c1c75ad9a95ecb3?d=https%3A%2F%2Fidenticons.github.com%2F3231749a6d256f6b819ff0aef52ecd03.png&amp;r=x&amp;s=140" width="24" />
            <a href="/jordandh">jordandh</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="Dave Methvin" class=" js-avatar" data-user="157858" height="24" src="https://0.gravatar.com/avatar/161a4cc619398bea1e1714036ed122cf?d=https%3A%2F%2Fidenticons.github.com%2F5408b5993e9003e9e3394257eff47f20.png&amp;r=x&amp;s=140" width="24" />
            <a href="/dmethvin">dmethvin</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="davedf" class=" js-avatar" data-user="298180" height="24" src="https://0.gravatar.com/avatar/398ac8cccb86108f072869b7b2ec8a23?d=https%3A%2F%2Fidenticons.github.com%2F72e4af299f5728b0d0e39bbdba336c31.png&amp;r=x&amp;s=140" width="24" />
            <a href="/davedf">davedf</a>
          </li>
      </ul>
    </div>
  </div>

<div class="file-box">
  <div class="file">
    <div class="meta clearfix">
      <div class="info file-name">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
        <span class="meta-divider"></span>
          <span>201 lines (198 sloc)</span>
          <span class="meta-divider"></span>
        <span>6.456 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
            <a class="minibutton tooltipped tooltipped-w"
               href="http://windows.github.com" aria-label="Open this file in GitHub for Windows">
                <span class="octicon octicon-device-desktop"></span> Open
            </a>
              <a class="minibutton disabled tooltipped tooltipped-w" href="#"
                 aria-label="You must be signed in to make or propose changes">Edit</a>
          <a href="/mindmup/bootstrap-wysiwyg/raw/master/bootstrap-wysiwyg.js" class="button minibutton " id="raw-url">Raw</a>
            <a href="/mindmup/bootstrap-wysiwyg/blame/master/bootstrap-wysiwyg.js" class="button minibutton js-update-url-with-hash">Blame</a>
          <a href="/mindmup/bootstrap-wysiwyg/commits/master/bootstrap-wysiwyg.js" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->
          <a class="minibutton danger disabled empty-icon tooltipped tooltipped-w" href="#"
             aria-label="You must be signed in to make or propose changes">
          Delete
        </a>
      </div><!-- /.actions -->
    </div>
        <div class="blob-wrapper data type-javascript js-blob-data">
        <table class="file-code file-diff tab-size-8">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>

            </td>
            <td class="blob-line-code"><div class="code-body highlight"><pre><div class='line' id='LC1'><span class="cm">/* http://github.com/mindmup/bootstrap-wysiwyg */</span></div><div class='line' id='LC2'><span class="cm">/*global jQuery, $, FileReader*/</span></div><div class='line' id='LC3'><span class="cm">/*jslint browser:true*/</span></div><div class='line' id='LC4'><span class="p">(</span><span class="kd">function</span> <span class="p">(</span><span class="nx">$</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC5'>	<span class="s1">&#39;use strict&#39;</span><span class="p">;</span></div><div class='line' id='LC6'>	<span class="kd">var</span> <span class="nx">readFileIntoDataUrl</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">fileInfo</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC7'>		<span class="kd">var</span> <span class="nx">loader</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">Deferred</span><span class="p">(),</span></div><div class='line' id='LC8'>			<span class="nx">fReader</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">FileReader</span><span class="p">();</span></div><div class='line' id='LC9'>		<span class="nx">fReader</span><span class="p">.</span><span class="nx">onload</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC10'>			<span class="nx">loader</span><span class="p">.</span><span class="nx">resolve</span><span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">target</span><span class="p">.</span><span class="nx">result</span><span class="p">);</span></div><div class='line' id='LC11'>		<span class="p">};</span></div><div class='line' id='LC12'>		<span class="nx">fReader</span><span class="p">.</span><span class="nx">onerror</span> <span class="o">=</span> <span class="nx">loader</span><span class="p">.</span><span class="nx">reject</span><span class="p">;</span></div><div class='line' id='LC13'>		<span class="nx">fReader</span><span class="p">.</span><span class="nx">onprogress</span> <span class="o">=</span> <span class="nx">loader</span><span class="p">.</span><span class="nx">notify</span><span class="p">;</span></div><div class='line' id='LC14'>		<span class="nx">fReader</span><span class="p">.</span><span class="nx">readAsDataURL</span><span class="p">(</span><span class="nx">fileInfo</span><span class="p">);</span></div><div class='line' id='LC15'>		<span class="k">return</span> <span class="nx">loader</span><span class="p">.</span><span class="nx">promise</span><span class="p">();</span></div><div class='line' id='LC16'>	<span class="p">};</span></div><div class='line' id='LC17'>	<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">cleanHtml</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC18'>		<span class="kd">var</span> <span class="nx">html</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">html</span><span class="p">();</span></div><div class='line' id='LC19'>		<span class="k">return</span> <span class="nx">html</span> <span class="o">&amp;&amp;</span> <span class="nx">html</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="sr">/(&lt;br&gt;|\s|&lt;div&gt;&lt;br&gt;&lt;\/div&gt;|&amp;nbsp;)*$/</span><span class="p">,</span> <span class="s1">&#39;&#39;</span><span class="p">);</span></div><div class='line' id='LC20'>	<span class="p">};</span></div><div class='line' id='LC21'>	<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">wysiwyg</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">userOptions</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC22'>		<span class="kd">var</span> <span class="nx">editor</span> <span class="o">=</span> <span class="k">this</span><span class="p">,</span></div><div class='line' id='LC23'>			<span class="nx">selectedRange</span><span class="p">,</span></div><div class='line' id='LC24'>			<span class="nx">options</span><span class="p">,</span></div><div class='line' id='LC25'>			<span class="nx">toolbarBtnSelector</span><span class="p">,</span></div><div class='line' id='LC26'>			<span class="nx">updateToolbar</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC27'>				<span class="k">if</span> <span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">activeToolbarClass</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC28'>					<span class="nx">$</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">toolbarSelector</span><span class="p">).</span><span class="nx">find</span><span class="p">(</span><span class="nx">toolbarBtnSelector</span><span class="p">).</span><span class="nx">each</span><span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC29'>						<span class="kd">var</span> <span class="nx">command</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">data</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span><span class="p">);</span></div><div class='line' id='LC30'>						<span class="k">if</span> <span class="p">(</span><span class="nb">document</span><span class="p">.</span><span class="nx">queryCommandState</span><span class="p">(</span><span class="nx">command</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC31'>							<span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">addClass</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">activeToolbarClass</span><span class="p">);</span></div><div class='line' id='LC32'>						<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC33'>							<span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">removeClass</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">activeToolbarClass</span><span class="p">);</span></div><div class='line' id='LC34'>						<span class="p">}</span></div><div class='line' id='LC35'>					<span class="p">});</span></div><div class='line' id='LC36'>				<span class="p">}</span></div><div class='line' id='LC37'>			<span class="p">},</span></div><div class='line' id='LC38'>			<span class="nx">execCommand</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">commandWithArgs</span><span class="p">,</span> <span class="nx">valueArg</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC39'>				<span class="kd">var</span> <span class="nx">commandArr</span> <span class="o">=</span> <span class="nx">commandWithArgs</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39; &#39;</span><span class="p">),</span></div><div class='line' id='LC40'>					<span class="nx">command</span> <span class="o">=</span> <span class="nx">commandArr</span><span class="p">.</span><span class="nx">shift</span><span class="p">(),</span></div><div class='line' id='LC41'>					<span class="nx">args</span> <span class="o">=</span> <span class="nx">commandArr</span><span class="p">.</span><span class="nx">join</span><span class="p">(</span><span class="s1">&#39; &#39;</span><span class="p">)</span> <span class="o">+</span> <span class="p">(</span><span class="nx">valueArg</span> <span class="o">||</span> <span class="s1">&#39;&#39;</span><span class="p">);</span></div><div class='line' id='LC42'>				<span class="nb">document</span><span class="p">.</span><span class="nx">execCommand</span><span class="p">(</span><span class="nx">command</span><span class="p">,</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">args</span><span class="p">);</span></div><div class='line' id='LC43'>				<span class="nx">updateToolbar</span><span class="p">();</span></div><div class='line' id='LC44'>			<span class="p">},</span></div><div class='line' id='LC45'>			<span class="nx">bindHotkeys</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">hotKeys</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC46'>				<span class="nx">$</span><span class="p">.</span><span class="nx">each</span><span class="p">(</span><span class="nx">hotKeys</span><span class="p">,</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">hotkey</span><span class="p">,</span> <span class="nx">command</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC47'>					<span class="nx">editor</span><span class="p">.</span><span class="nx">keydown</span><span class="p">(</span><span class="nx">hotkey</span><span class="p">,</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC48'>						<span class="k">if</span> <span class="p">(</span><span class="nx">editor</span><span class="p">.</span><span class="nx">attr</span><span class="p">(</span><span class="s1">&#39;contenteditable&#39;</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">editor</span><span class="p">.</span><span class="nx">is</span><span class="p">(</span><span class="s1">&#39;:visible&#39;</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC49'>							<span class="nx">e</span><span class="p">.</span><span class="nx">preventDefault</span><span class="p">();</span></div><div class='line' id='LC50'>							<span class="nx">e</span><span class="p">.</span><span class="nx">stopPropagation</span><span class="p">();</span></div><div class='line' id='LC51'>							<span class="nx">execCommand</span><span class="p">(</span><span class="nx">command</span><span class="p">);</span></div><div class='line' id='LC52'>						<span class="p">}</span></div><div class='line' id='LC53'>					<span class="p">}).</span><span class="nx">keyup</span><span class="p">(</span><span class="nx">hotkey</span><span class="p">,</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC54'>						<span class="k">if</span> <span class="p">(</span><span class="nx">editor</span><span class="p">.</span><span class="nx">attr</span><span class="p">(</span><span class="s1">&#39;contenteditable&#39;</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">editor</span><span class="p">.</span><span class="nx">is</span><span class="p">(</span><span class="s1">&#39;:visible&#39;</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC55'>							<span class="nx">e</span><span class="p">.</span><span class="nx">preventDefault</span><span class="p">();</span></div><div class='line' id='LC56'>							<span class="nx">e</span><span class="p">.</span><span class="nx">stopPropagation</span><span class="p">();</span></div><div class='line' id='LC57'>						<span class="p">}</span></div><div class='line' id='LC58'>					<span class="p">});</span></div><div class='line' id='LC59'>				<span class="p">});</span></div><div class='line' id='LC60'>			<span class="p">},</span></div><div class='line' id='LC61'>			<span class="nx">getCurrentRange</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC62'>				<span class="kd">var</span> <span class="nx">sel</span> <span class="o">=</span> <span class="nb">window</span><span class="p">.</span><span class="nx">getSelection</span><span class="p">();</span></div><div class='line' id='LC63'>				<span class="k">if</span> <span class="p">(</span><span class="nx">sel</span><span class="p">.</span><span class="nx">getRangeAt</span> <span class="o">&amp;&amp;</span> <span class="nx">sel</span><span class="p">.</span><span class="nx">rangeCount</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC64'>					<span class="k">return</span> <span class="nx">sel</span><span class="p">.</span><span class="nx">getRangeAt</span><span class="p">(</span><span class="mi">0</span><span class="p">);</span></div><div class='line' id='LC65'>				<span class="p">}</span></div><div class='line' id='LC66'>			<span class="p">},</span></div><div class='line' id='LC67'>			<span class="nx">saveSelection</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC68'>				<span class="nx">selectedRange</span> <span class="o">=</span> <span class="nx">getCurrentRange</span><span class="p">();</span></div><div class='line' id='LC69'>			<span class="p">},</span></div><div class='line' id='LC70'>			<span class="nx">restoreSelection</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC71'>				<span class="kd">var</span> <span class="nx">selection</span> <span class="o">=</span> <span class="nb">window</span><span class="p">.</span><span class="nx">getSelection</span><span class="p">();</span></div><div class='line' id='LC72'>				<span class="k">if</span> <span class="p">(</span><span class="nx">selectedRange</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC73'>					<span class="k">try</span> <span class="p">{</span></div><div class='line' id='LC74'>						<span class="nx">selection</span><span class="p">.</span><span class="nx">removeAllRanges</span><span class="p">();</span></div><div class='line' id='LC75'>					<span class="p">}</span> <span class="k">catch</span> <span class="p">(</span><span class="nx">ex</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC76'>						<span class="nb">document</span><span class="p">.</span><span class="nx">body</span><span class="p">.</span><span class="nx">createTextRange</span><span class="p">().</span><span class="nx">select</span><span class="p">();</span></div><div class='line' id='LC77'>						<span class="nb">document</span><span class="p">.</span><span class="nx">selection</span><span class="p">.</span><span class="nx">empty</span><span class="p">();</span></div><div class='line' id='LC78'>					<span class="p">}</span></div><div class='line' id='LC79'><br/></div><div class='line' id='LC80'>					<span class="nx">selection</span><span class="p">.</span><span class="nx">addRange</span><span class="p">(</span><span class="nx">selectedRange</span><span class="p">);</span></div><div class='line' id='LC81'>				<span class="p">}</span></div><div class='line' id='LC82'>			<span class="p">},</span></div><div class='line' id='LC83'>			<span class="nx">insertFiles</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">files</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC84'>				<span class="nx">editor</span><span class="p">.</span><span class="nx">focus</span><span class="p">();</span></div><div class='line' id='LC85'>				<span class="nx">$</span><span class="p">.</span><span class="nx">each</span><span class="p">(</span><span class="nx">files</span><span class="p">,</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">idx</span><span class="p">,</span> <span class="nx">fileInfo</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC86'>					<span class="k">if</span> <span class="p">(</span><span class="sr">/^image\//</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">fileInfo</span><span class="p">.</span><span class="nx">type</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC87'>						<span class="nx">$</span><span class="p">.</span><span class="nx">when</span><span class="p">(</span><span class="nx">readFileIntoDataUrl</span><span class="p">(</span><span class="nx">fileInfo</span><span class="p">)).</span><span class="nx">done</span><span class="p">(</span><span class="kd">function</span> <span class="p">(</span><span class="nx">dataUrl</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC88'>							<span class="nx">execCommand</span><span class="p">(</span><span class="s1">&#39;insertimage&#39;</span><span class="p">,</span> <span class="nx">dataUrl</span><span class="p">);</span></div><div class='line' id='LC89'>						<span class="p">}).</span><span class="nx">fail</span><span class="p">(</span><span class="kd">function</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC90'>							<span class="nx">options</span><span class="p">.</span><span class="nx">fileUploadError</span><span class="p">(</span><span class="s2">&quot;file-reader&quot;</span><span class="p">,</span> <span class="nx">e</span><span class="p">);</span></div><div class='line' id='LC91'>						<span class="p">});</span></div><div class='line' id='LC92'>					<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC93'>						<span class="nx">options</span><span class="p">.</span><span class="nx">fileUploadError</span><span class="p">(</span><span class="s2">&quot;unsupported-file-type&quot;</span><span class="p">,</span> <span class="nx">fileInfo</span><span class="p">.</span><span class="nx">type</span><span class="p">);</span></div><div class='line' id='LC94'>					<span class="p">}</span></div><div class='line' id='LC95'>				<span class="p">});</span></div><div class='line' id='LC96'>			<span class="p">},</span></div><div class='line' id='LC97'>			<span class="nx">markSelection</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">input</span><span class="p">,</span> <span class="nx">color</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC98'>				<span class="nx">restoreSelection</span><span class="p">();</span></div><div class='line' id='LC99'>				<span class="k">if</span> <span class="p">(</span><span class="nb">document</span><span class="p">.</span><span class="nx">queryCommandSupported</span><span class="p">(</span><span class="s1">&#39;hiliteColor&#39;</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC100'>					<span class="nb">document</span><span class="p">.</span><span class="nx">execCommand</span><span class="p">(</span><span class="s1">&#39;hiliteColor&#39;</span><span class="p">,</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">color</span> <span class="o">||</span> <span class="s1">&#39;transparent&#39;</span><span class="p">);</span></div><div class='line' id='LC101'>				<span class="p">}</span></div><div class='line' id='LC102'>				<span class="nx">saveSelection</span><span class="p">();</span></div><div class='line' id='LC103'>				<span class="nx">input</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">selectionMarker</span><span class="p">,</span> <span class="nx">color</span><span class="p">);</span></div><div class='line' id='LC104'>			<span class="p">},</span></div><div class='line' id='LC105'>			<span class="nx">bindToolbar</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">toolbar</span><span class="p">,</span> <span class="nx">options</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC106'>				<span class="nx">toolbar</span><span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="nx">toolbarBtnSelector</span><span class="p">).</span><span class="nx">click</span><span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC107'>					<span class="nx">restoreSelection</span><span class="p">();</span></div><div class='line' id='LC108'>					<span class="nx">editor</span><span class="p">.</span><span class="nx">focus</span><span class="p">();</span></div><div class='line' id='LC109'>					<span class="nx">execCommand</span><span class="p">(</span><span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">data</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span><span class="p">));</span></div><div class='line' id='LC110'>					<span class="nx">saveSelection</span><span class="p">();</span></div><div class='line' id='LC111'>				<span class="p">});</span></div><div class='line' id='LC112'>				<span class="nx">toolbar</span><span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">&#39;[data-toggle=dropdown]&#39;</span><span class="p">).</span><span class="nx">click</span><span class="p">(</span><span class="nx">restoreSelection</span><span class="p">);</span></div><div class='line' id='LC113'><br/></div><div class='line' id='LC114'>				<span class="nx">toolbar</span><span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">&#39;input[type=text][data-&#39;</span> <span class="o">+</span> <span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span> <span class="o">+</span> <span class="s1">&#39;]&#39;</span><span class="p">).</span><span class="nx">on</span><span class="p">(</span><span class="s1">&#39;webkitspeechchange change&#39;</span><span class="p">,</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC115'>					<span class="kd">var</span> <span class="nx">newValue</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">value</span><span class="p">;</span> <span class="cm">/* ugly but prevents fake double-calls due to selection restoration */</span></div><div class='line' id='LC116'>					<span class="k">this</span><span class="p">.</span><span class="nx">value</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC117'>					<span class="nx">restoreSelection</span><span class="p">();</span></div><div class='line' id='LC118'>					<span class="k">if</span> <span class="p">(</span><span class="nx">newValue</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC119'>						<span class="nx">editor</span><span class="p">.</span><span class="nx">focus</span><span class="p">();</span></div><div class='line' id='LC120'>						<span class="nx">execCommand</span><span class="p">(</span><span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">data</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span><span class="p">),</span> <span class="nx">newValue</span><span class="p">);</span></div><div class='line' id='LC121'>					<span class="p">}</span></div><div class='line' id='LC122'>					<span class="nx">saveSelection</span><span class="p">();</span></div><div class='line' id='LC123'>				<span class="p">}).</span><span class="nx">on</span><span class="p">(</span><span class="s1">&#39;focus&#39;</span><span class="p">,</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC124'>					<span class="kd">var</span> <span class="nx">input</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">);</span></div><div class='line' id='LC125'>					<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">input</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">selectionMarker</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC126'>						<span class="nx">markSelection</span><span class="p">(</span><span class="nx">input</span><span class="p">,</span> <span class="nx">options</span><span class="p">.</span><span class="nx">selectionColor</span><span class="p">);</span></div><div class='line' id='LC127'>						<span class="nx">input</span><span class="p">.</span><span class="nx">focus</span><span class="p">();</span></div><div class='line' id='LC128'>					<span class="p">}</span></div><div class='line' id='LC129'>				<span class="p">}).</span><span class="nx">on</span><span class="p">(</span><span class="s1">&#39;blur&#39;</span><span class="p">,</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC130'>					<span class="kd">var</span> <span class="nx">input</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">);</span></div><div class='line' id='LC131'>					<span class="k">if</span> <span class="p">(</span><span class="nx">input</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">selectionMarker</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC132'>						<span class="nx">markSelection</span><span class="p">(</span><span class="nx">input</span><span class="p">,</span> <span class="kc">false</span><span class="p">);</span></div><div class='line' id='LC133'>					<span class="p">}</span></div><div class='line' id='LC134'>				<span class="p">});</span></div><div class='line' id='LC135'>				<span class="nx">toolbar</span><span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">&#39;input[type=file][data-&#39;</span> <span class="o">+</span> <span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span> <span class="o">+</span> <span class="s1">&#39;]&#39;</span><span class="p">).</span><span class="nx">change</span><span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC136'>					<span class="nx">restoreSelection</span><span class="p">();</span></div><div class='line' id='LC137'>					<span class="k">if</span> <span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">type</span> <span class="o">===</span> <span class="s1">&#39;file&#39;</span> <span class="o">&amp;&amp;</span> <span class="k">this</span><span class="p">.</span><span class="nx">files</span> <span class="o">&amp;&amp;</span> <span class="k">this</span><span class="p">.</span><span class="nx">files</span><span class="p">.</span><span class="nx">length</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC138'>						<span class="nx">insertFiles</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">files</span><span class="p">);</span></div><div class='line' id='LC139'>					<span class="p">}</span></div><div class='line' id='LC140'>					<span class="nx">saveSelection</span><span class="p">();</span></div><div class='line' id='LC141'>					<span class="k">this</span><span class="p">.</span><span class="nx">value</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC142'>				<span class="p">});</span></div><div class='line' id='LC143'>			<span class="p">},</span></div><div class='line' id='LC144'>			<span class="nx">initFileDrops</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC145'>				<span class="nx">editor</span><span class="p">.</span><span class="nx">on</span><span class="p">(</span><span class="s1">&#39;dragenter dragover&#39;</span><span class="p">,</span> <span class="kc">false</span><span class="p">)</span></div><div class='line' id='LC146'>					<span class="p">.</span><span class="nx">on</span><span class="p">(</span><span class="s1">&#39;drop&#39;</span><span class="p">,</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC147'>						<span class="kd">var</span> <span class="nx">dataTransfer</span> <span class="o">=</span> <span class="nx">e</span><span class="p">.</span><span class="nx">originalEvent</span><span class="p">.</span><span class="nx">dataTransfer</span><span class="p">;</span></div><div class='line' id='LC148'>						<span class="nx">e</span><span class="p">.</span><span class="nx">stopPropagation</span><span class="p">();</span></div><div class='line' id='LC149'>						<span class="nx">e</span><span class="p">.</span><span class="nx">preventDefault</span><span class="p">();</span></div><div class='line' id='LC150'>						<span class="k">if</span> <span class="p">(</span><span class="nx">dataTransfer</span> <span class="o">&amp;&amp;</span> <span class="nx">dataTransfer</span><span class="p">.</span><span class="nx">files</span> <span class="o">&amp;&amp;</span> <span class="nx">dataTransfer</span><span class="p">.</span><span class="nx">files</span><span class="p">.</span><span class="nx">length</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC151'>							<span class="nx">insertFiles</span><span class="p">(</span><span class="nx">dataTransfer</span><span class="p">.</span><span class="nx">files</span><span class="p">);</span></div><div class='line' id='LC152'>						<span class="p">}</span></div><div class='line' id='LC153'>					<span class="p">});</span></div><div class='line' id='LC154'>			<span class="p">};</span></div><div class='line' id='LC155'>		<span class="nx">options</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">extend</span><span class="p">({},</span> <span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">wysiwyg</span><span class="p">.</span><span class="nx">defaults</span><span class="p">,</span> <span class="nx">userOptions</span><span class="p">);</span></div><div class='line' id='LC156'>		<span class="nx">toolbarBtnSelector</span> <span class="o">=</span> <span class="s1">&#39;a[data-&#39;</span> <span class="o">+</span> <span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span> <span class="o">+</span> <span class="s1">&#39;],button[data-&#39;</span> <span class="o">+</span> <span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span> <span class="o">+</span> <span class="s1">&#39;],input[type=button][data-&#39;</span> <span class="o">+</span> <span class="nx">options</span><span class="p">.</span><span class="nx">commandRole</span> <span class="o">+</span> <span class="s1">&#39;]&#39;</span><span class="p">;</span></div><div class='line' id='LC157'>		<span class="nx">bindHotkeys</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">hotKeys</span><span class="p">);</span></div><div class='line' id='LC158'>		<span class="k">if</span> <span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">dragAndDropImages</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC159'>			<span class="nx">initFileDrops</span><span class="p">();</span></div><div class='line' id='LC160'>		<span class="p">}</span></div><div class='line' id='LC161'>		<span class="nx">bindToolbar</span><span class="p">(</span><span class="nx">$</span><span class="p">(</span><span class="nx">options</span><span class="p">.</span><span class="nx">toolbarSelector</span><span class="p">),</span> <span class="nx">options</span><span class="p">);</span></div><div class='line' id='LC162'>		<span class="nx">editor</span><span class="p">.</span><span class="nx">attr</span><span class="p">(</span><span class="s1">&#39;contenteditable&#39;</span><span class="p">,</span> <span class="kc">true</span><span class="p">)</span></div><div class='line' id='LC163'>			<span class="p">.</span><span class="nx">on</span><span class="p">(</span><span class="s1">&#39;mouseup keyup mouseout&#39;</span><span class="p">,</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC164'>				<span class="nx">saveSelection</span><span class="p">();</span></div><div class='line' id='LC165'>				<span class="nx">updateToolbar</span><span class="p">();</span></div><div class='line' id='LC166'>			<span class="p">});</span></div><div class='line' id='LC167'>		<span class="nx">$</span><span class="p">(</span><span class="nb">window</span><span class="p">).</span><span class="nx">bind</span><span class="p">(</span><span class="s1">&#39;touchend&#39;</span><span class="p">,</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC168'>			<span class="kd">var</span> <span class="nx">isInside</span> <span class="o">=</span> <span class="p">(</span><span class="nx">editor</span><span class="p">.</span><span class="nx">is</span><span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">target</span><span class="p">)</span> <span class="o">||</span> <span class="nx">editor</span><span class="p">.</span><span class="nx">has</span><span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">target</span><span class="p">).</span><span class="nx">length</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="p">),</span></div><div class='line' id='LC169'>				<span class="nx">currentRange</span> <span class="o">=</span> <span class="nx">getCurrentRange</span><span class="p">(),</span></div><div class='line' id='LC170'>				<span class="nx">clear</span> <span class="o">=</span> <span class="nx">currentRange</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">currentRange</span><span class="p">.</span><span class="nx">startContainer</span> <span class="o">===</span> <span class="nx">currentRange</span><span class="p">.</span><span class="nx">endContainer</span> <span class="o">&amp;&amp;</span> <span class="nx">currentRange</span><span class="p">.</span><span class="nx">startOffset</span> <span class="o">===</span> <span class="nx">currentRange</span><span class="p">.</span><span class="nx">endOffset</span><span class="p">);</span></div><div class='line' id='LC171'>			<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">clear</span> <span class="o">||</span> <span class="nx">isInside</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC172'>				<span class="nx">saveSelection</span><span class="p">();</span></div><div class='line' id='LC173'>				<span class="nx">updateToolbar</span><span class="p">();</span></div><div class='line' id='LC174'>			<span class="p">}</span></div><div class='line' id='LC175'>		<span class="p">});</span></div><div class='line' id='LC176'>		<span class="k">return</span> <span class="k">this</span><span class="p">;</span></div><div class='line' id='LC177'>	<span class="p">};</span></div><div class='line' id='LC178'>	<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">wysiwyg</span><span class="p">.</span><span class="nx">defaults</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC179'>		<span class="nx">hotKeys</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC180'>			<span class="s1">&#39;ctrl+b meta+b&#39;</span><span class="o">:</span> <span class="s1">&#39;bold&#39;</span><span class="p">,</span></div><div class='line' id='LC181'>			<span class="s1">&#39;ctrl+i meta+i&#39;</span><span class="o">:</span> <span class="s1">&#39;italic&#39;</span><span class="p">,</span></div><div class='line' id='LC182'>			<span class="s1">&#39;ctrl+u meta+u&#39;</span><span class="o">:</span> <span class="s1">&#39;underline&#39;</span><span class="p">,</span></div><div class='line' id='LC183'>			<span class="s1">&#39;ctrl+z meta+z&#39;</span><span class="o">:</span> <span class="s1">&#39;undo&#39;</span><span class="p">,</span></div><div class='line' id='LC184'>			<span class="s1">&#39;ctrl+y meta+y meta+shift+z&#39;</span><span class="o">:</span> <span class="s1">&#39;redo&#39;</span><span class="p">,</span></div><div class='line' id='LC185'>			<span class="s1">&#39;ctrl+l meta+l&#39;</span><span class="o">:</span> <span class="s1">&#39;justifyleft&#39;</span><span class="p">,</span></div><div class='line' id='LC186'>			<span class="s1">&#39;ctrl+r meta+r&#39;</span><span class="o">:</span> <span class="s1">&#39;justifyright&#39;</span><span class="p">,</span></div><div class='line' id='LC187'>			<span class="s1">&#39;ctrl+e meta+e&#39;</span><span class="o">:</span> <span class="s1">&#39;justifycenter&#39;</span><span class="p">,</span></div><div class='line' id='LC188'>			<span class="s1">&#39;ctrl+j meta+j&#39;</span><span class="o">:</span> <span class="s1">&#39;justifyfull&#39;</span><span class="p">,</span></div><div class='line' id='LC189'>			<span class="s1">&#39;shift+tab&#39;</span><span class="o">:</span> <span class="s1">&#39;outdent&#39;</span><span class="p">,</span></div><div class='line' id='LC190'>			<span class="s1">&#39;tab&#39;</span><span class="o">:</span> <span class="s1">&#39;indent&#39;</span></div><div class='line' id='LC191'>		<span class="p">},</span></div><div class='line' id='LC192'>		<span class="nx">toolbarSelector</span><span class="o">:</span> <span class="s1">&#39;[data-role=editor-toolbar]&#39;</span><span class="p">,</span></div><div class='line' id='LC193'>		<span class="nx">commandRole</span><span class="o">:</span> <span class="s1">&#39;edit&#39;</span><span class="p">,</span></div><div class='line' id='LC194'>		<span class="nx">activeToolbarClass</span><span class="o">:</span> <span class="s1">&#39;btn-info&#39;</span><span class="p">,</span></div><div class='line' id='LC195'>		<span class="nx">selectionMarker</span><span class="o">:</span> <span class="s1">&#39;edit-focus-marker&#39;</span><span class="p">,</span></div><div class='line' id='LC196'>		<span class="nx">selectionColor</span><span class="o">:</span> <span class="s1">&#39;darkgrey&#39;</span><span class="p">,</span></div><div class='line' id='LC197'>		<span class="nx">dragAndDropImages</span><span class="o">:</span> <span class="kc">true</span><span class="p">,</span></div><div class='line' id='LC198'>		<span class="nx">fileUploadError</span><span class="o">:</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">reason</span><span class="p">,</span> <span class="nx">detail</span><span class="p">)</span> <span class="p">{</span> <span class="nx">console</span><span class="p">.</span><span class="nx">log</span><span class="p">(</span><span class="s2">&quot;File upload error&quot;</span><span class="p">,</span> <span class="nx">reason</span><span class="p">,</span> <span class="nx">detail</span><span class="p">);</span> <span class="p">}</span></div><div class='line' id='LC199'>	<span class="p">};</span></div><div class='line' id='LC200'><span class="p">}(</span><span class="nb">window</span><span class="p">.</span><span class="nx">jQuery</span><span class="p">));</span></div></pre></div></td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2014 <span title="0.02654s from github-fe128-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped tooltipped-w" aria-label="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped tooltipped-w"
      aria-label="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close js-ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

  </body>
</html>

