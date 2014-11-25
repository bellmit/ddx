<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${lab.name} Prescription - 订单 ${cases.caseId }</title>
        <style type="text/css">
        <!--
        /* Style Definitions */
        p.MsoNormal, li.MsoNormal, div.MsoNormal {
            mso-style-parent: "";
            margin: 0in;
            margin-bottom: .0001pt;
            mso-pagination: widow-orphan;
            font-size: 12.0pt;
            font-family: "Times New Roman";
            mso-fareast-font-family: "Times New Roman";
        }
        
        span.SpellE {
            mso-style-name: "";
            mso-spl-e: yes;
        }
        @page Section1 {size:
            8.5in 11.0in;
            margin:
            .5in .5in .5in .5in;
            mso-header-margin:
            .5in;
            mso-footer-margin:
            .5in;
            mso-paper-source:
            0;
        }
        
        div.Section1 {
            page: Section1;
        }
        
        .ui-icon {
            display: block;
            text-indent: -99999px;
            overflow: hidden;
            background-repeat: no-repeat;
        }
        
        .ui-icon {
            width: 16px;
            height: 16px;
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_005dab_256x240.png);
        }
        
        .ui-widget-content .ui-icon {
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_005dab_256x240.png);
        }
        
        .ui-widget-header .ui-icon {
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_005dab_256x240.png);
        }
        
        .ui-state-default .ui-icon {
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_00aeef_256x240.png);
        }
        
        .ui-state-hover .ui-icon, .ui-state-focus .ui-icon {
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_00aeef_256x240.png);
        }
        
        .ui-state-active .ui-icon {
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_00aeef_256x240.png);
        }
        
        .ui-state-highlight .ui-icon {
            background-image: url(${pageContext.request.contextPath}/css/images/ui-icons_ffffff_256x240.png);
        }
        
        .ui-state-error .ui-icon, .ui-state-error-text .ui-icon {
            background-image: url(${pageContext.request.contextPath}/css/images/ui-icons_ffffff_256x240.png);
        }
        
        /* positioning */
        .ui-icon-carat-1-n {
            background-position: 0 0;
        }
        
        .ui-icon-carat-1-ne {
            background-position: -16px 0;
        }
        
        .ui-icon-carat-1-e {
            background-position: -32px 0;
        }
        
        .ui-icon-carat-1-se {
            background-position: -48px 0;
        }
        
        .ui-icon-carat-1-s {
            background-position: -64px 0;
        }
        
        .ui-icon-carat-1-sw {
            background-position: -80px 0;
        }
        
        .ui-icon-carat-1-w {
            background-position: -96px 0;
        }
        
        .ui-icon-carat-1-nw {
            background-position: -112px 0;
        }
        
        .ui-icon-carat-2-n-s {
            background-position: -128px 0;
        }
        
        .ui-icon-carat-2-e-w {
            background-position: -144px 0;
        }
        
        .ui-icon-triangle-1-n {
            background-position: 0 -16px;
        }
        
        .ui-icon-triangle-1-ne {
            background-position: -16px -16px;
        }
        
        .ui-icon-triangle-1-e {
            background-position: -32px -16px;
        }
        
        .ui-icon-triangle-1-se {
            background-position: -48px -16px;
        }
        
        .ui-icon-triangle-1-s {
            background-position: -64px -16px;
        }
        
        .ui-icon-triangle-1-sw {
            background-position: -80px -16px;
        }
        
        .ui-icon-triangle-1-w {
            background-position: -96px -16px;
        }
        
        .ui-icon-triangle-1-nw {
            background-position: -112px -16px;
        }
        
        .ui-icon-triangle-2-n-s {
            background-position: -128px -16px;
        }
        
        .ui-icon-triangle-2-e-w {
            background-position: -144px -16px;
        }
        
        .ui-icon-arrow-1-n {
            background-position: 0 -32px;
        }
        
        .ui-icon-arrow-1-ne {
            background-position: -16px -32px;
        }
        
        .ui-icon-arrow-1-e {
            background-position: -32px -32px;
        }
        
        .ui-icon-arrow-1-se {
            background-position: -48px -32px;
        }
        
        .ui-icon-arrow-1-s {
            background-position: -64px -32px;
        }
        
        .ui-icon-arrow-1-sw {
            background-position: -80px -32px;
        }
        
        .ui-icon-arrow-1-w {
            background-position: -96px -32px;
        }
        
        .ui-icon-arrow-1-nw {
            background-position: -112px -32px;
        }
        
        .ui-icon-arrow-2-n-s {
            background-position: -128px -32px;
        }
        
        .ui-icon-arrow-2-ne-sw {
            background-position: -144px -32px;
        }
        
        .ui-icon-arrow-2-e-w {
            background-position: -160px -32px;
        }
        
        .ui-icon-arrow-2-se-nw {
            background-position: -176px -32px;
        }
        
        .ui-icon-arrowstop-1-n {
            background-position: -192px -32px;
        }
        
        .ui-icon-arrowstop-1-e {
            background-position: -208px -32px;
        }
        
        .ui-icon-arrowstop-1-s {
            background-position: -224px -32px;
        }
        
        .ui-icon-arrowstop-1-w {
            background-position: -240px -32px;
        }
        
        .ui-icon-arrowthick-1-n {
            background-position: 0 -48px;
        }
        
        .ui-icon-arrowthick-1-ne {
            background-position: -16px -48px;
        }
        
        .ui-icon-arrowthick-1-e {
            background-position: -32px -48px;
        }
        
        .ui-icon-arrowthick-1-se {
            background-position: -48px -48px;
        }
        
        .ui-icon-arrowthick-1-s {
            background-position: -64px -48px;
        }
        
        .ui-icon-arrowthick-1-sw {
            background-position: -80px -48px;
        }
        
        .ui-icon-arrowthick-1-w {
            background-position: -96px -48px;
        }
        
        .ui-icon-arrowthick-1-nw {
            background-position: -112px -48px;
        }
        
        .ui-icon-arrowthick-2-n-s {
            background-position: -128px -48px;
        }
        
        .ui-icon-arrowthick-2-ne-sw {
            background-position: -144px -48px;
        }
        
        .ui-icon-arrowthick-2-e-w {
            background-position: -160px -48px;
        }
        
        .ui-icon-arrowthick-2-se-nw {
            background-position: -176px -48px;
        }
        
        .ui-icon-arrowthickstop-1-n {
            background-position: -192px -48px;
        }
        
        .ui-icon-arrowthickstop-1-e {
            background-position: -208px -48px;
        }
        
        .ui-icon-arrowthickstop-1-s {
            background-position: -224px -48px;
        }
        
        .ui-icon-arrowthickstop-1-w {
            background-position: -240px -48px;
        }
        
        .ui-icon-arrowreturnthick-1-w {
            background-position: 0 -64px;
        }
        
        .ui-icon-arrowreturnthick-1-n {
            background-position: -16px -64px;
        }
        
        .ui-icon-arrowreturnthick-1-e {
            background-position: -32px -64px;
        }
        
        .ui-icon-arrowreturnthick-1-s {
            background-position: -48px -64px;
        }
        
        .ui-icon-arrowreturn-1-w {
            background-position: -64px -64px;
        }
        
        .ui-icon-arrowreturn-1-n {
            background-position: -80px -64px;
        }
        
        .ui-icon-arrowreturn-1-e {
            background-position: -96px -64px;
        }
        
        .ui-icon-arrowreturn-1-s {
            background-position: -112px -64px;
        }
        
        .ui-icon-arrowrefresh-1-w {
            background-position: -128px -64px;
        }
        
        .ui-icon-arrowrefresh-1-n {
            background-position: -144px -64px;
        }
        
        .ui-icon-arrowrefresh-1-e {
            background-position: -160px -64px;
        }
        
        .ui-icon-arrowrefresh-1-s {
            background-position: -176px -64px;
        }
        
        .ui-icon-arrow-4 {
            background-position: 0 -80px;
        }
        
        .ui-icon-arrow-4-diag {
            background-position: -16px -80px;
        }
        
        .ui-icon-extlink {
            background-position: -32px -80px;
        }
        
        .ui-icon-newwin {
            background-position: -48px -80px;
        }
        
        .ui-icon-refresh {
            background-position: -64px -80px;
        }
        
        .ui-icon-shuffle {
            background-position: -80px -80px;
        }
        
        .ui-icon-transfer-e-w {
            background-position: -96px -80px;
        }
        
        .ui-icon-transferthick-e-w {
            background-position: -112px -80px;
        }
        
        .ui-icon-folder-collapsed {
            background-position: 0 -96px;
        }
        
        .ui-icon-folder-open {
            background-position: -16px -96px;
        }
        
        .ui-icon-document {
            background-position: -32px -96px;
        }
        
        .ui-icon-document-b {
            background-position: -48px -96px;
        }
        
        .ui-icon-note {
            background-position: -64px -96px;
        }
        
        .ui-icon-mail-closed {
            background-position: -80px -96px;
        }
        
        .ui-icon-mail-open {
            background-position: -96px -96px;
        }
        
        .ui-icon-suitcase {
            background-position: -112px -96px;
        }
        
        .ui-icon-comment {
            background-position: -128px -96px;
        }
        
        .ui-icon-person {
            background-position: -144px -96px;
        }
        
        .ui-icon-print {
            background-position: -160px -96px;
        }
        
        .ui-icon-trash {
            background-position: -176px -96px;
        }
        
        .ui-icon-locked {
            background-position: -192px -96px;
        }
        
        .ui-icon-unlocked {
            background-position: -208px -96px;
        }
        
        .ui-icon-bookmark {
            background-position: -224px -96px;
        }
        
        .ui-icon-tag {
            background-position: -240px -96px;
        }
        
        .ui-icon-home {
            background-position: 0 -112px;
        }
        
        .ui-icon-flag {
            background-position: -16px -112px;
        }
        
        .ui-icon-calendar {
            background-position: -32px -112px;
        }
        
        .ui-icon-cart {
            background-position: -48px -112px;
        }
        
        .ui-icon-pencil {
            background-position: -64px -112px;
        }
        
        .ui-icon-clock {
            background-position: -80px -112px;
        }
        
        .ui-icon-disk {
            background-position: -96px -112px;
        }
        
        .ui-icon-calculator {
            background-position: -112px -112px;
        }
        
        .ui-icon-zoomin {
            background-position: -128px -112px;
        }
        
        .ui-icon-zoomout {
            background-position: -144px -112px;
        }
        
        .ui-icon-search {
            background-position: -160px -112px;
        }
        
        .ui-icon-wrench {
            background-position: -176px -112px;
        }
        
        .ui-icon-gear {
            background-position: -192px -112px;
        }
        
        .ui-icon-heart {
            background-position: -208px -112px;
        }
        
        .ui-icon-star {
            background-position: -224px -112px;
        }
        
        .ui-icon-link {
            background-position: -240px -112px;
        }
        
        .ui-icon-cancel {
            background-position: 0 -128px;
        }
        
        .ui-icon-plus {
            background-position: -16px -128px;
        }
        
        .ui-icon-plusthick {
            background-position: -32px -128px;
        }
        
        .ui-icon-minus {
            background-position: -48px -128px;
        }
        
        .ui-icon-minusthick {
            background-position: -64px -128px;
        }
        
        .ui-icon-close {
            background-position: -80px -128px;
        }
        
        .ui-icon-closethick {
            background-position: -96px -128px;
        }
        
        .ui-icon-key {
            background-position: -112px -128px;
        }
        
        .ui-icon-lightbulb {
            background-position: -128px -128px;
        }
        
        .ui-icon-scissors {
            background-position: -144px -128px;
        }
        
        .ui-icon-clipboard {
            background-position: -160px -128px;
        }
        
        .ui-icon-copy {
            background-position: -176px -128px;
        }
        
        .ui-icon-contact {
            background-position: -192px -128px;
        }
        
        .ui-icon-image {
            background-position: -208px -128px;
        }
        
        .ui-icon-video {
            background-position: -224px -128px;
        }
        
        .ui-icon-script {
            background-position: -240px -128px;
        }
        
        .ui-icon-alert {
            background-position: 0 -144px;
        }
        
        .ui-icon-info {
            background-position: -16px -144px;
        }
        
        .ui-icon-notice {
            background-position: -32px -144px;
        }
        
        .ui-icon-help {
            background-position: -48px -144px;
        }
        
        .ui-icon-check {
            background-position: -64px -144px;
        }
        
        .ui-icon-bullet {
            background-position: -80px -144px;
        }
        
        .ui-icon-radio-off {
            background-position: -96px -144px;
        }
        
        .ui-icon-radio-on {
            background-position: -112px -144px;
        }
        
        .ui-icon-pin-w {
            background-position: -128px -144px;
        }
        
        .ui-icon-pin-s {
            background-position: -144px -144px;
        }
        
        .ui-icon-play {
            background-position: 0 -160px;
        }
        
        .ui-icon-pause {
            background-position: -16px -160px;
        }
        
        .ui-icon-seek-next {
            background-position: -32px -160px;
        }
        
        .ui-icon-seek-prev {
            background-position: -48px -160px;
        }
        
        .ui-icon-seek-end {
            background-position: -64px -160px;
        }
        
        .ui-icon-seek-start {
            background-position: -80px -160px;
        }
        
        /* ui-icon-seek-first is deprecated, use ui-icon-seek-start instead */
        .ui-icon-seek-first {
            background-position: -80px -160px;
        }
        
        .ui-icon-stop {
            background-position: -96px -160px;
        }
        
        .ui-icon-eject {
            background-position: -112px -160px;
        }
        
        .ui-icon-volume-off {
            background-position: -128px -160px;
        }
        
        .ui-icon-volume-on {
            background-position: -144px -160px;
        }
        
        .ui-icon-power {
            background-position: 0 -176px;
        }
        
        .ui-icon-signal-diag {
            background-position: -16px -176px;
        }
        
        .ui-icon-signal {
            background-position: -32px -176px;
        }
        
        .ui-icon-battery-0 {
            background-position: -48px -176px;
        }
        
        .ui-icon-battery-1 {
            background-position: -64px -176px;
        }
        
        .ui-icon-battery-2 {
            background-position: -80px -176px;
        }
        
        .ui-icon-battery-3 {
            background-position: -96px -176px;
        }
        
        .ui-icon-circle-plus {
            background-position: 0 -192px;
        }
        
        .ui-icon-circle-minus {
            background-position: -16px -192px;
        }
        
        .ui-icon-circle-close {
            background-position: -32px -192px;
        }
        
        .ui-icon-circle-triangle-e {
            background-position: -48px -192px;
        }
        
        .ui-icon-circle-triangle-s {
            background-position: -64px -192px;
        }
        
        .ui-icon-circle-triangle-w {
            background-position: -80px -192px;
        }
        
        .ui-icon-circle-triangle-n {
            background-position: -96px -192px;
        }
        
        .ui-icon-circle-arrow-e {
            background-position: -112px -192px;
        }
        
        .ui-icon-circle-arrow-s {
            background-position: -128px -192px;
        }
        
        .ui-icon-circle-arrow-w {
            background-position: -144px -192px;
        }
        
        .ui-icon-circle-arrow-n {
            background-position: -160px -192px;
        }
        
        .ui-icon-circle-zoomin {
            background-position: -176px -192px;
        }
        
        .ui-icon-circle-zoomout {
            background-position: -192px -192px;
        }
        
        .ui-icon-circle-check {
            background-position: -208px -192px;
        }
        
        .ui-icon-circlesmall-plus {
            background-position: 0 -208px;
        }
        
        .ui-icon-circlesmall-minus {
            background-position: -16px -208px;
        }
        
        .ui-icon-circlesmall-close {
            background-position: -32px -208px;
        }
        
        .ui-icon-squaresmall-plus {
            background-position: -48px -208px;
        }
        
        .ui-icon-squaresmall-minus {
            background-position: -64px -208px;
        }
        
        .ui-icon-squaresmall-close {
            background-position: -80px -208px;
        }
        
        .ui-icon-grip-dotted-vertical {
            background-position: 0 -224px;
        }
        
        .ui-icon-grip-dotted-horizontal {
            background-position: -16px -224px;
        }
        
        .ui-icon-grip-solid-vertical {
            background-position: -32px -224px;
        }
        
        .ui-icon-grip-solid-horizontal {
            background-position: -48px -224px;
        }
        
        .ui-icon-gripsmall-diagonal-se {
            background-position: -64px -224px;
        }
        
        .ui-icon-grip-diagonal-se {
            background-position: -80px -224px;
        }
        
        .ui-button {
            display: inline-block;
            position: relative;
            padding: 0;
            margin-right: .1em;
            text-decoration: none !important;
            cursor: pointer;
            text-align: center;
            zoom: 1;
            overflow: visible;
        }
         /* the overflow property removes extra width in IE */
        .ui-button-icon-only {
            width: 2.2em;
        }
         /* to make room for the icon, a width needs to be set here */
        button.ui-button-icon-only {
            width: 2.4em;
        }
         /* button elements seem to need a little more width */
        .ui-button-icons-only {
            width: 3.4em;
        }
        
        button.ui-button-icons-only {
            width: 3.7em;
        }
        
        /*button text element */
        .ui-button .ui-button-text {
            display: block;
            line-height: 1.4;
        }
        
        .ui-button-text-only .ui-button-text {
            padding: .4em 1em;
        }
        
        .ui-button-icon-only .ui-button-text, .ui-button-icons-only .ui-button-text {
            padding: .4em;
            text-indent: -9999999px;
        }
        
        .ui-button-text-icon-primary .ui-button-text, .ui-button-text-icons .ui-button-text {
            padding: .4em 1em .4em 2.1em;
        }
        
        .ui-button-text-icon-secondary .ui-button-text, .ui-button-text-icons .ui-button-text {
            padding: .4em 2.1em .4em 1em;
        }
        
        .ui-button-text-icons .ui-button-text {
            padding-left: 2.1em;
            padding-right: 2.1em;
        }
        
        /* no icon support for input elements, provide padding by default */
        input.ui-button {
            padding: .4em 1em;
        }
        
        /*button icon element(s) */
        .ui-button-icon-only .ui-icon, .ui-button-text-icon-primary .ui-icon, .ui-button-text-icon-secondary .ui-icon, .ui-button-text-icons .ui-icon, .ui-button-icons-only .ui-icon {
            position: absolute;
            top: 50%;
            margin-top: -8px;
        }
        
        .ui-button-icon-only .ui-icon {
            left: 50%;
            margin-left: -8px;
        }
        
        .ui-button-text-icon-primary .ui-button-icon-primary, .ui-button-text-icons .ui-button-icon-primary, .ui-button-icons-only .ui-button-icon-primary {
            left: .5em;
        }
        
        .ui-button-text-icon-secondary .ui-button-icon-secondary, .ui-button-text-icons .ui-button-icon-secondary, .ui-button-icons-only .ui-button-icon-secondary {
            right: .5em;
        }
        
        .ui-button-text-icons .ui-button-icon-secondary, .ui-button-icons-only .ui-button-icon-secondary {
            right: .5em;
        }
        
        .ui-button-text-icon-primary .ui-button-text, .ui-button-text-icons .ui-button-text {
            padding: 0em 0.2em 0em 1.5em;
        }
        
        .ui-button-text-icon-secondary .ui-button-text {
            padding: 0em 2.1em 0em 0.2em;
        }
        
        input[type = button], input[type = submit], input[type = reset], button {
            margin-right: 2px;
            margin-left: 2px;
            text-decoration: none;
            color: #ffffff;
            padding: 0.2em 0.5em 0.2em 0.5em !important;
            background: url("${pageContext.request.contextPath}/jsp/practice/images/ui-bg_highlight-soft_100_005dab_1x100.png") repeat-x scroll 50% 50% #005dab;
            border: 1px solid #005dab;
            -moz-border-radius-topleft: 5px;
            -webkit-border-top-left-radius: 5px;
            border-top-left-radius: 5px;
            -moz-border-radius-topright: 5px;
            -webkit-border-top-right-radius: 5px;
            border-top-right-radius: 5px;
            -moz-border-radius-bottomleft: 5px;
            -webkit-border-bottom-left-radius: 5px;
            border-bottom-left-radius: 5px;
            -moz-border-radius-bottomright: 5px;
            -webkit-border-bottom-right-radius: 5px;
            border-bottom-right-radius: 5px;
            font-weight: bold;
            vertical-align: top;
        }
        
        input[type = button].ui-button, input[type = submit].ui-button, input[type = reset].ui-button, button.ui-button {
            padding: 0.2em 0.8em 0.2em 0.0em !important;
        }
        
        input[type = button] .ui-button-text, input[type = submit] .ui-button-text, input[type = reset] .ui-button-text, button .ui-button-text {
            padding: 0em 0.2em 0em 1.9em !important;
        }
        
        input[type = button] .ui-icon, input[type = submit] .ui-icon, input[type = reset] .ui-icon, button .ui-icon, a.button .ui-icon {
            background-image: url(${pageContext.request.contextPath}/css/images/ui-icons_ffffff_256x240.png);
        }
        
        .ui-widget-content input[type = button] .ui-icon, .ui-widget-content input[type = submit] .ui-icon, .ui-widget-content input[type = reset] .ui-icon, .ui-widget-content button .ui-icon, .ui-widget-content a.button .ui-icon {
            background-image: url(${pageContext.request.contextPath}/css/images/ui-icons_ffffff_256x240.png);
        }
        
        a.button {
            float: left;
            margin-right: 2px;
            margin-left: 2px;
            text-decoration: none;
            color: #ffffff;
            padding: 0.2em 0.5em 0.2em 0.5em !important;
            background: url("${pageContext.request.contextPath}/jsp/practice/images/ui-bg_highlight-soft_100_005dab_1x100.png") repeat-x scroll 50% 50% #005dab;
            border: 1px solid #005dab;
            -moz-border-radius-topleft: 5px;
            -webkit-border-top-left-radius: 5px;
            border-top-left-radius: 5px;
            -moz-border-radius-topright: 5px;
            -webkit-border-top-right-radius: 5px;
            border-top-right-radius: 5px;
            -moz-border-radius-bottomleft: 5px;
            -webkit-border-bottom-left-radius: 5px;
            border-bottom-left-radius: 5px;
            -moz-border-radius-bottomright: 5px;
            -webkit-border-bottom-right-radius: 5px;
            border-bottom-right-radius: 5px;
            font: 13px / 1.231 Arial 宋体, helvetica, clean, sans-serif;
            font-size: 85%;
            font-weight: bold;
        }
        
        a.button:hover {
            background: url("${pageContext.request.contextPath}/jsp/practice/images/ui-bg_highlight-soft_100_d6e9f5_1x100.png") repeat-x scroll 50% 50% #eeeeee;
            border: 1px solid #d6e9f5;
            color: #000000;
        }
        
        input[type = button]:hover, input[type = submit]:hover, input[type = reset]:hover, button:hover, a.button:hover {
            background: url("${pageContext.request.contextPath}/jsp/practice/images/ui-bg_highlight-soft_100_d6e9f5_1x100.png") repeat-x scroll 50% 50% #eeeeee;
            border: 1px solid #d6e9f5;
            color: #000000;
        }
        
        input[type = button]:hover .ui-icon, input[type = submit]:hover .ui-icon, input[type = reset]:hover .ui-icon, button:hover .ui-icon, a.button:hover .ui-icon {
            background-image: url(${pageContext.request.contextPath}/jsp/practice/images/ui-icons_005dab_256x240.png);
        }
        
        .print_only {
            display: none;
        }
        @media print { .no_print {display:none;
        }
        
        .print_only {
                display: block;
        }
        }
        -->
        </style>
        <!--[if gte mso 10]>
            <style type="text/css">
            /* Style Definitions */
            table.MsoNormalTable
            {mso-style-name:"Table Normal";
            mso-tstyle-rowband-size:0;
            mso-tstyle-colband-size:0;
            mso-style-noshow:yes;
            mso-style-parent:"";
            mso-padding-alt:0in 5.4pt 0in 5.4pt;
            mso-para-margin:0in;
            mso-para-margin-bottom:.0001pt;
            mso-pagination:widow-orphan;
            font-size:10.0pt;
            font-family:"Times New Roman";}
            </style>
        <![endif]-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
        </script>
        <script type="text/javascript">
            $(document).ready(function(){
                window.print();
                
                $(".no_print").on("click", ".print", function(event){
                    event.stopPropagation();
                    event.preventDefault();
                    
                    window.print();
                });
            });
        </script>
    </head>
    <body style="tab-interval:.5in">
        <table class="no_print" style="margin-left:5.4pt; margin-bottom: 20px;" border="1" cellpadding="0" cellspacing="0">
            <tbody>
                <tr>
                    <td style="width:8in; border: 1px solid #CCC; background-color: #F6F6F6; padding: .5em 1em .3em;  height:30pt">
                        <p class="MsoNormal">
                            <a class="button ui-button ui-button-text-icon-primary print" href="${pageContext.request.contextPath}/casesAction/practicePrintWork.do?caseId=${cases.caseId}" title="Please print work authorization for this case and include it with your case materials"><span class="ui-button-icon-primary ui-icon ui-icon-print"></span><span class="ui-button-text">重新打印</span></a>
                            <a class="button ui-button ui-button-text-icon-primary" href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.caseId}" title="Return to case"><span class="ui-button-icon-primary ui-icon ui-icon-arrowreturnthick-1-w"></span><span class="ui-button-text">返回订单 #${cases.caseId}</span></a>
                        </p>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="Section1">
            <table class="MsoNormalTable" style="margin-left:5.4pt;border-collapse:collapse;border:none;mso-border-alt:double windowtext 1.5pt;mso-padding-alt:0in 5.4pt 0in 5.4pt;mso-border-insideh:1.5pt double windowtext;mso-border-insidev:1.5pt double windowtext" border="1" cellpadding="0" cellspacing="0">
                <tbody>
                    <tr style="mso-yfti-irow:0;height:69.75pt">
                        <td colspan="2" rowspan="2" style="width:3.5in;border:double windowtext 1.5pt; border-bottom:solid windowtext 1.0pt;mso-border-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:69.75pt" valign="top" width="336">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">发往: 
                                        ${lab.name} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${lab.address} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${lab.country}--${lab.state}--${lab.city} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${lab.zipCode} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">联系方式: 
                                        ${lab.phoneNumber} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">证件号码: ${lab.licenseNumber} </span></b>
                            </p>
                        </td>
                        <td colspan="2" style="width:4.0in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:69.75pt" valign="top" width="384">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">来自: ${cases.provider} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${cases.practice} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${practice.address} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${practice.country}--${practice.state}--${practice.city} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${practice.zipCode} </span></b>
                            </p>
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${practice.phoneNumber} </span></b>
                            </p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:1;height:9.0pt">
                        <td style="width:1.5in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:9.0pt" width="144">
                            <p class="MsoNormal" style="text-align:right" align="right">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">患者名:</span></b>
                            </p>
                        </td>
                        <td style="width:2.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:9.0pt" width="240">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体">${cases.patient}</span></b>
                            </p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:2;height:7.5pt">
                        <td rowspan="4" style="width:1.25in;border:none;border-left:double windowtext 1.5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="120">
                            <p class="MsoNormal" style="text-align:center" align="center">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:24.0pt;font-family:Arial 宋体">${cases.caseId } </span></b>
                            </p>
                            <div style="text-align:center; font-size:9.0pt;font-family:Arial 宋体">
                            <c:if test="${cases.isTryIn eq 'Y' }">
                                <b style="mso-bidi-font-weight:normal">试戴: 是 </b>
                            </c:if>
							</div>
                        </td>
                        <td rowspan="4" style="width:2.25in;border:none;border-right:double windowtext 1.5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="216">
                            <p class="MsoNormal" style="text-align:center" align="center">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:10.0pt;font-family:Arial 宋体"><%-- <img src="${pageContext.request.contextPath}/jsp/practice/images/barcode/330.png" alt="330" align="middle"> --%><img src="<%=request.getContextPath() %>/barCode/imgCreate.do?msg=${cases.caseId}&BARCODE_TYPE=code39&&mw=0.35&fmt=png" title="${cases.caseId}" alt="${cases.caseId}" align="middle" /></span></b>
                            </p>
                        </td>
                        <td style="width:1.5in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="144">
                            <p class="MsoNormal" style="text-align:right" align="right">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">患者ID:</span></b>
                            </p>
                        </td>
                        <td style="width:2.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="240">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体"></span></b>
                            </p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:5;height:2.5pt">
                        <td style="width:1.5in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:2.5pt" width="144">
                            <p class="MsoNormal" style="text-align:right" align="right">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">主治医师:</span></b>
                            </p>
                        </td>
                        <td style="width:2.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:2.5pt" width="240">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">${cases.provider} </span></b>
                            </p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:5;height:2.5pt">
                        <td style="width:1.5in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:2.5pt" width="144">
                            <p class="MsoNormal" style="text-align:right" align="right">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">预交付日期:</span></b>
                            </p>
                        </td>
                        <td style="width:2.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:2.5pt" width="240">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:16.0pt;font-family:Arial 宋体"><fmt:formatDate value="${cases.deliveryDate}" type="date"/> </span></b>
                            </p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:4;height:5.25pt">
                        <td style="width:1.5in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:5.25pt" width="144">
                            <p class="MsoNormal" style="text-align:right" align="right">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">预寄出日期:</span></b>
                            </p>
                        </td>
                        <td style="width:2.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:5.25pt" width="240">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体"><fmt:formatDate value="${cases.sendToLabDate}" type="date"/> </span></b>
                            </p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:6;mso-yfti-lastrow:yes;height:6.6pt">
                        <td colspan="2" style="width:3.5in;border:double windowtext 1.5pt;border-top:none;padding:0in 5.4pt 0in 5.4pt;height:6.6pt" valign="top" width="336">
                            <p class="MsoNormal" style="text-align:center" align="center">
                            </p>
                        </td>
                        <td style="width:1.5in;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:6.6pt" width="144">
                            <p class="MsoNormal" style="text-align:right" align="right">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">患者预约日期:</span></b>
                            </p>
                        </td>
                        <td style="width:2.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:6.6pt" width="240">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体"><fmt:formatDate value="${cases.patAppDate}" type="date"/></span></b>
                            </p>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p class="MsoNormal">
                &nbsp;
            </p>
            <table class="MsoNormalTable" style="margin-left:5.4pt;border-collapse:collapse;border:none;mso-border-alt:double windowtext 1.5pt;mso-padding-alt:0in 5.4pt 0in 5.4pt;mso-border-insideh:1.5pt double windowtext;mso-border-insidev:1.5pt double windowtext" border="1" cellpadding="0" cellspacing="0">
                <tbody>
                    <tr style="mso-yfti-irow:0;height:15.0pt">
                        <td colspan="3" style="width:4.75in;border-top:double 1.5pt;border-left:double 1.5pt;border-bottom:solid 1.0pt;border-right:solid 1.0pt;border-color:windowtext;mso-border-top-alt:double 1.5pt;mso-border-left-alt:double 1.5pt;mso-border-bottom-alt:solid .5pt;mso-border-right-alt:solid .5pt;mso-border-color-alt:windowtext;padding:0in 5.4pt 0in 5.4pt;height:15.0pt" width="456">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">制作工序 </span></b>
                            </p>
                        </td>
                        <td style="width:.5in;border-top:double windowtext 1.5pt;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;mso-border-top-alt:double windowtext 1.5pt;padding:0in 5.4pt 0in 5.4pt;height:15.0pt" width="48">
                            <p class="MsoNormal" style="text-align:center" align="center">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">计数 </span></b>
                            </p>
                        </td>
                        <td rowspan="5" style="width:2.35in;border:double windowtext 1.5pt;border-left:none;mso-border-left-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:15.0pt" valign="top" width="144">
                            <p class="MsoNormal" style="text-align:center" align="center">
                                <span style="font-size:9.0pt;font-family:Arial 宋体"><img src="${pageContext.request.contextPath}/jsp/practice/images/teeth2.gif" alt="teeth" height="236" width="126"></span>
                            </p>
                        </td>
                    </tr>
                    
                    <!-- 工序部分 -->
                    <c:forEach items="${proceduresList}" var="pro">
                    <tr style="mso-yfti-irow:1;height:7.5pt">
                        <td colspan="3" style="width:4.75in;border-top:none;border-left:double windowtext 1.5pt;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;mso-border-left-alt:double windowtext 1.5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="456">
                            <p class="MsoNormal">
                                <span style="font-size:9.0pt;font-family:Arial 宋体"><b>${pro.procedure_name }</b>                                    &nbsp;
                                <br/>
									  		<div>
									  			<table style="width: 100%;margin-left: 6px;border: none;">
									  					<c:forEach items="${pro.attrList}" var="attr">
									  						<c:if test="${!empty attr.valueDes }">
									  							<tr>
												  					<td style="padding: 0"><span style="font-size:8.5pt;font-family:Arial 宋体"><strong>${attr.lable }&nbsp;&nbsp;</strong>${attr.valueDes }</span></td>
												  				</tr>
									  						</c:if>
									  					</c:forEach>
									  			</table>
									  		</div>
                                </span>
                            </p>
                        </td>
                        <td style="width:.5in;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="48">
                            <p class="MsoNormal" style="text-align:center" align="center">
                                <span style="font-size:9.0pt;font-family:Arial 宋体">${pro.count } </span>
                            </p>
                        </td>
                        <%-- <td style="width:.75in;border-top:none;border-left:none;border-bottom: solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:7.5pt" width="72">
                            <p class="MsoNormal" style="text-align:center" align="center">
                                <span style="font-size:9.0pt;font-family:Arial 宋体">${pro.ps } </span>
                            </p>
                        </td> --%>
                    </tr>
                    </c:forEach>
                    
                    <tr style="mso-yfti-irow:8;height:30.0pt">
                        <td colspan="6" style="width:7.5in;border:double windowtext 1.5pt;border-top:none;mso-border-top-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:30.0pt" valign="top" width="720">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tbody>
                                    <tr style="mso-yfti-irow:7;height:45.0pt">
                                        <td valign="top">
                                            <p class="MsoNormal">
                                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">阴影备注:</span></b>
                                            </p>
                                            <span style="font-size:9.0pt;font-family:Arial 宋体"></span>
                                        </td>
                                        <td valign="top">
                                            <p class="MsoNormal">
                                                <img src="${pageContext.request.contextPath}/jsp/practice/images/shades2.gif" alt="Shades" height="60" hspace="12" width="225" align="left">
                                            </p>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:9;height:190pt">
                        <td colspan="6" style="width:7.5in;border:double windowtext 1.5pt;border-top:none;mso-border-top-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:190pt" valign="top" width="720">
                            <p class="MsoNormal">
                                <b style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">订单备注:</span></b>
                                <span style="font-size:9.0pt;font-family:Arial 宋体">
                                <c:choose>
									<c:when test="${notePm.total eq 0 }">
									<br/><br/><br/><br/>
									</c:when>
									<c:otherwise>
										<c:forEach items="${notePm.datas }" var="note">
											&nbsp;&nbsp;${note.caseNote }
										</c:forEach>
									</c:otherwise>
								</c:choose>
                                </span>
                            </p>
                            <p class="MsoNormal">
								<span style="font-size: 9.0pt; font-family: Arial 宋体"> <b>随单附件:</b>
								<c:choose>
									<c:when test="${enclourses eq null }">
									<br/><br/><br/><br/>
									</c:when>
									<c:otherwise>
										<c:forEach items="${enclourses }" var="obj">
											&nbsp;&nbsp;${obj.characterName }
										</c:forEach>
									</c:otherwise>
								</c:choose>
								</span>
							</p>
                        </td>
                    </tr>
                    <tr style="mso-yfti-irow:10;mso-yfti-lastrow:yes;height:26.5pt">
                        <td colspan="6" style="width:7.5in;border:double windowtext 1.5pt;border-top:none;mso-border-top-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt;height:26.5pt" valign="bottom" width="720">
                            <table width="100%" border="0">
                                <tbody>
                                    <tr>
                                        <td valign="bottom" width="50%">
                                            <b class="MsoNormal" style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">证件号码: 
                                                    ${practice.prefCaseLicense} </span></b>
                                        </td>
                                        <td valign="bottom" width="50%">
                                            <b class="MsoNormal" style="mso-bidi-font-weight:normal"><span style="font-size:9.0pt;font-family:Arial 宋体">签名:</span></b>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
