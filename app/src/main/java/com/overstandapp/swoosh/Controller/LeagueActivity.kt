package com.overstandapp.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.overstandapp.swoosh.Model.Player
import com.overstandapp.swoosh.R
//import com.overstandapp.swoosh.Utilities.EXTRA_LEAGUE
import com.overstandapp.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*


class LeagueActivity : BaseActivity() {

    var player = Player("", "")
    //var selectedLeague = ""

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View){
        womensToggleButton.isChecked = false
        coedToggleButton.isChecked = false

        player.league = "mens"

    }

    fun onWomensClicked(view: View){
        mensToggleButton.isChecked = false
        coedToggleButton.isChecked = false
        player.league = "womans"

    }

    fun onCoedClicked(view: View){
        mensToggleButton.isChecked = false
        womensToggleButton.isChecked = false
        player.league = "coed"

    }

    fun leagueNextClicked(view: View) {
        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this,"Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}
