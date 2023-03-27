@file:Suppress("DEPRECATION")

package anzila.binar.latihanfragmentketiga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.ImageView
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager.widget.ViewPager
import anzila.binar.latihanfragmentketiga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "TabPager"
        supportActionBar?.elevation = 0.0f

        var adapter = TabAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        adapter = binding.viewPager

        binding.tabLayout.setupWithViewPager(adapter)

        val icon_tab = LayoutInflater.from(this).inflate(R.layout.tab_icon, null)
        val imageViewXml = binding.imageView
        icon_tab.imageViewXml.setImageResource(R.drawable.baseline_photo_camera_24)

        binding.tabLayout.getTabAt(3)
    }


    class TabAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {
        private val tabName : Array<String> = arrayOf("Home", "Status", "Profile", "Camera")

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> HomeFragment()
            1 -> StatusFragment()
            2 -> ProfileFragment()
            3 -> CameraFragment()
            else -> HomeFragment()
        }

        override fun getCount(): Int = 4
        override fun getPageTitle(position: Int): CharSequence = tabName.get(position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}